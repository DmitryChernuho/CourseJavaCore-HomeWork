package home_work_1.producer_queue_consumer.task_classes;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    private ConcurrentLinkedQueue<Integer> queue;
    private Thread producerthread;
    private final FileUtil fileUtil = new FileUtil(FilesData.LOG_FILE_NAME.getFileData());

    public Consumer(int number, ConcurrentLinkedQueue<Integer> queue, Thread producerTread) {
        super("Consumer num. " + number);
        this.queue = queue;
        this.producerthread = producerTread;
    }

    @Override
    public void run() {
        int number;
        while (!Thread.currentThread().isInterrupted() && (producerthread.isAlive() || queue.size() > 0)) {
            if (queue.size() < 1) {
                sleep(1);
                fileUtil.logSleepStatusInFile("...");
                continue;
            }
            number = queue.poll();
            sleep(number);
            fileUtil.logSleepStatusInFile(String.format("I slept %s seconds", number));
        }
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
