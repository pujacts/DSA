package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable{

    private final BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try{
            process();
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void process() throws  InterruptedException{

        for(int i =0 ; i< 20; i++){
            System.out.println("[thread.Producer] Put : " + i);
            queue.put(i);
            System.out.println("[thread.Producer] Queue remainingCapacity : " + queue.remainingCapacity());
            Thread.sleep(100);
        }
    }
}

class Consumer implements Runnable{

    private final BlockingQueue<Integer> queue ;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                Integer take = queue.take();
                process(take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void process(Integer take) throws InterruptedException {
        System.out.println("[thread.Consumer] Take : " + take);
        Thread.sleep(500);
    }
}
