import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class StatementRecord {}

public class Task3 {

    // FIX: Use AtomicInteger for thread safety
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);

                // FIX: Thread-safe increment
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processRecord(StatementRecord record) {}

    public int getProcessedCount() {
        return processedCount.get();
    }
}
