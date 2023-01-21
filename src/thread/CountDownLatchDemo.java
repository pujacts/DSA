package thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static final CountDownLatch latch = new CountDownLatch(3);
    public static void main(String[] args) {

        Thread cacheService = new Thread(new Service("cacheservice", 1000, latch));
        Thread validationService = new Thread(new Service("validationService", 1000, latch));
        Thread alertService = new Thread(new Service("alertservice", 1000, latch));

        cacheService.start();
        alertService.start();
        validationService.start();

        try {
            cacheService.join();
            alertService.join();
            validationService.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            latch.await();
            System.out.println("All services are up, Application is starting now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Service implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch countDownLatch;

    Service(String name, int timeToStart, CountDownLatch countDownLatch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( name + " is Up");
        countDownLatch.countDown();
    }

}
