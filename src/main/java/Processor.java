import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable {

    private CountDownLatch countDownLatch;

    // constructor of each object of class 'Processor'
    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    // each thread wait 3 seconds and begin his job, countDownLatch.countDown();
    @Override
    public void run() {
        try {
            Thread.sleep(3000); // sleep 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown(); // count back to open the latch
    }
}
