package main.java.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerFlow implements Runnable {
    private final Thread producerTread;
    private final BlockingQueue<Integer> queueNumbers;

    public ConsumerFlow(Thread producerTread, BlockingQueue<Integer> queueNumbers) {
        this.producerTread = producerTread;
        this.queueNumbers = queueNumbers;
    }

    @Override
    public void run() {
        FileUtil fileUtil = new FileUtil("logFile.txt");
        while (producerTread.isAlive() || queueNumbers.size() != 0) {
            if (queueNumbers.size() == 0) {
                System.out.println("Start sleeping on 1 seconds");
                sleep(1);
                System.out.println("Stop sleeping on 1 seconds");
                fileUtil.logSleepStatusInFile("...");
                continue;
            }
            int number = queueNumbers.element();
            System.out.println("Start sleeping on " + number + " seconds");
            sleep(number);
            System.out.println("Stop sleeping on " + number + " seconds");
            queueNumbers.poll();
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
