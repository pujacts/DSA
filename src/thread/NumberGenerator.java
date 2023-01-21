package thread;

public class NumberGenerator implements Runnable{

    private static final int MAX = 20;

    private static final int noOfThread = 3;

    private  volatile int number = 1;

    //private final int remainder;

    private final Object lock = new Object();


    @Override
    public void run() {
        while(number<MAX){
            synchronized (lock){ // remainder = 1, 2, 0
                if(number%noOfThread != Integer.parseInt(Thread.currentThread().getName())){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                lock.notifyAll();
            }


        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        new Thread(numberGenerator, "1").start();
        new Thread(numberGenerator, "2").start();
        new Thread(numberGenerator, "0").start();
    }
}
