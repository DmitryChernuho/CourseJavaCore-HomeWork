package home_work_1.producer_queue_consumer.task_classes;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    private final FileUtil fileUtil = new FileUtil("logFile.txt");

    public Consumer(int number) {
        super("Consumer num. " + number);
    }

    @Override
    public void run() {
        while (ThreadDataHelper.producerThread.isAlive() || ThreadDataHelper.getQueueSize() > 0) {
            if (ThreadDataHelper.getQueueSize() < 1) {
                sleep(1);
                fileUtil.logSleepStatusInFile("...");
                continue;
            }
            int number = ThreadDataHelper.getNumber();
            sleep(number);
            fileUtil.logSleepStatusInFile(String.format("I slept %s seconds", number));
        }
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
