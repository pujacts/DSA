package thread;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayedQueueExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        DelayQueue<DelayedEvent> queue = new DelayQueue<>();
        AtomicInteger counter = new AtomicInteger();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new DelayedEventProducer(queue, counter), 1, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new DelayedEventConsumer(queue), 1, 10, TimeUnit.SECONDS);
    }
}

class DelayedEventProducer implements Runnable{

    private final DelayQueue<DelayedEvent> queue;
    private final AtomicInteger counter;

    DelayedEventProducer(DelayQueue<DelayedEvent> queue, AtomicInteger counter) {
        this.queue = queue;
        this.counter = counter;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        int id = counter.incrementAndGet();
        DelayedEvent event = new DelayedEvent(id, "Task-" + id, now);
        System.out.println("Added to queue :: " + event);
        queue.add(event);
    }
}
class DelayedEventConsumer implements Runnable{

    private final DelayQueue<DelayedEvent> queue;

    DelayedEventConsumer(DelayQueue<DelayedEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        List<DelayedEvent> events = new ArrayList<DelayedEvent>();
        queue.drainTo(events);
        System.out.println("\nEvent processing start **********\n");
        events.stream().forEach(System.out::println);
        System.out.println("\nEvent processing end **********\n");
    }
}
