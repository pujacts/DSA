package thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All task have been finished");
            }
        });

        for(int i = 0 ; i< 5; i++){
            service.execute(new Worker(i+1, cyclicBarrier));
        }
    }


}

class Worker implements Runnable{
    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    Worker(int id, CyclicBarrier cyclicBarrier){
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }
    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("thread with id "+ this.id + "starts the work....");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("after await");
    }
}
