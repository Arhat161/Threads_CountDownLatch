import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// In this example we use class CountDownLatch to assign how many times should the method
// 'countDownLatch.countDown()' be called in different threads for the latch to open
// We create three threads using 'Executor', and give each thread his job in cycle 'for'
// after completion of work, we disable all threads using 'executorService.shutdown()'
// and wait with 'countDownLatch.await()' to continue the main thread

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3); // where 3 is how many times should the method
        // countDownLatch.countDown(); be called in different threads for the latch to open

        ExecutorService executorService = Executors.newFixedThreadPool(3); // create 3 threads

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch)); // give threads their jobs
        }

        // each thread wait 3 seconds and start run his job

        executorService.shutdown(); // disable all threads
        countDownLatch.await(); // when countDownLatch() == 0, latch is opening and thread main continue
        System.out.println("Latch has been open, main thread is proceeding!");
    }
}
