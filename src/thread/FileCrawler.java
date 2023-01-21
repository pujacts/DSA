package thread;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileCrawler {

    private static final File POISON = new File("This is a POISON PILL");

    public static void main(String[] args) {

        int N_PRODUCERS = 1;
        int N_CONSUMERS = 2;//Runtime.getRuntime().availableProcessors();
        int N_POISON_PILL_PER_PRODUCER = N_CONSUMERS / N_PRODUCERS;
        int N_POISON_PILL_REMAIN = N_CONSUMERS % N_PRODUCERS;

        System.out.println("N_PRODUCERS : " + N_PRODUCERS);
        System.out.println("N_CONSUMERS : " + N_CONSUMERS);
        System.out.println("N_POISON_PILL_PER_PRODUCER : " + N_POISON_PILL_PER_PRODUCER);
        System.out.println("N_POISON_PILL_REMAIN : " + N_POISON_PILL_REMAIN);

        //unbound queue, no limit
        BlockingQueue<File> queue = new LinkedBlockingQueue<>();

        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        };

        File root = new File("C:\\Users\\pujap\\OneDrive\\Pictures");

        for (int i = 0; i < N_PRODUCERS - 1; i++) {
            new Thread(new FileCrawlerProducer(queue, filter, root,
                    POISON, N_POISON_PILL_PER_PRODUCER)).start();
        }
        new Thread(new FileCrawlerProducer(queue, filter, root, POISON,
                N_POISON_PILL_PER_PRODUCER + N_POISON_PILL_REMAIN)).start();

        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new IndexerConsumer(queue, POISON)).start();
        }
    }
}

class FileCrawlerProducer implements Runnable{
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File file;
    private final File POISON;
    private final int N_POISON_PILL_PER_PRODUCER;
    FileCrawlerProducer(BlockingQueue<File> fileQue, FileFilter fileFilter, File file, File poison, int n_poison_pill_per_producer) {
        this.fileQueue = fileQue;
        this.fileFilter = fileFilter;
        this.file = file;
        POISON = poison;
        N_POISON_PILL_PER_PRODUCER = n_poison_pill_per_producer;
    }

    @Override
    public void run() {
        try {
            crawl(file);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " - FileCrawlerProducer is done, try poison all the consumers!");
                    // poison all threads
                    for (int i = 0; i < N_POISON_PILL_PER_PRODUCER; i++) {
                        System.out.println(Thread.currentThread().getName() + " - puts poison pill!");
                        fileQueue.put(POISON);
                    }
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

    private void crawl(File root) throws InterruptedException {

        File[] entries = root.listFiles(fileFilter);
        if(entries!=null){
            for(File entry : entries){
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!isIndexed(entry)) {
                    System.out.println("[FileCrawlerProducer] - Found..."
                            + entry.getAbsoluteFile());
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean isIndexed(File entry) {
        return false;
    }
}

class IndexerConsumer implements Runnable{

    private final BlockingQueue<File> fileQueue;
    private final File POISON;

    IndexerConsumer(BlockingQueue<File> fileQueue, File poison) {
        this.fileQueue = fileQueue;
        POISON = poison;
    }

    @Override
    public void run() {

        try {
            while (true) {
                File take = fileQueue.take();
                if (take == POISON) {
                    System.out.println(Thread.currentThread().getName() + " die");
                    break;
                }
                indexFile(take);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void indexFile(File file) {
        if (file.isFile()) {
            System.out.println(Thread.currentThread().getName()
                    + " [IndexerConsumer] - Indexing..." + file.getAbsoluteFile());
        }

    }

}
