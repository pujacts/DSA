package thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0; i<5; i++){
            executorService.execute(new Task(i));
        }
    }

}

class Task implements Runnable{

    private int id;

    Task(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("task id :" + id + "is in work with -thread id:" + Thread.currentThread().getName());
        long duration = (long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
