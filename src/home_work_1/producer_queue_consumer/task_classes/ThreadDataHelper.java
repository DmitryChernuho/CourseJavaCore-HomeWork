package home_work_1.producer_queue_consumer.task_classes;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadDataHelper {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    public static Thread producerThread;

    public static void addNumber(Integer number) {
        queue.add(number);
    }

    public static synchronized Integer getNumber() {
        return queue.poll();
    }

    public static synchronized int getQueueSize() {
        return queue.size();
    }

    private ThreadDataHelper() {
    }
}
