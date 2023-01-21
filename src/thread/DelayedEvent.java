package thread;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedEvent implements Delayed {
    private final long id;
    private final String name;
    private final LocalDateTime activationDateTime;

    public DelayedEvent(long id, String name, LocalDateTime activationDateTime) {
        this.id = id;
        this.name = name;
        this.activationDateTime = activationDateTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        LocalDateTime now = LocalDateTime.now();
        long diff = now.until(activationDateTime, ChronoUnit.MILLIS);
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed that) {

        long result = this.getDelay(TimeUnit.NANOSECONDS)
                - that.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "DelayedEvent [id=" + id + ", name=" + name + ", activationDateTime=" + activationDateTime + "]";
    }
}
