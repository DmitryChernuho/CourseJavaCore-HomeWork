package main.java.concurrency;

import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadUtil {
    public static void openThreadsForEvenQueueElement(Thread producerThread, BlockingQueue<Integer> queue, int columnThreads) {
        BlockingQueue<Integer> oneQueueElement = new LinkedBlockingQueue<>();
        Thread consumerThread = null;
        while (producerThread.isAlive()) {
            if (queue.size() > 0) {
                for (int i = 0; i < queue.size(); i++) {
                    oneQueueElement.add(queue.poll());
                    new Thread(new ConsumerFlow(producerThread, oneQueueElement)).start();
                }
                Set<Thread> threads = Thread.getAllStackTraces().keySet();
                for (Thread thread : threads) {
                    thread.interrupt();
                }
                continue;
            }
            if (consumerThread == null) {
                consumerThread = new Thread(new ConsumerFlow(producerThread, queue));
                consumerThread.start();
            }
        }
    }
//        BlockingQueue<Integer> oneQueueElement = new LinkedBlockingQueue<>();
//        ExecutorService executor = Executors.newFixedThreadPool(columnThreads);
//        Future<?> future = null;
//        while (producerThread.isAlive()) {
//            if (queue.size() > 0) {
//                try {
//                    future.get();
//                } catch (InterruptedException | ExecutionException exception) {
//                    exception.printStackTrace();
//                }
//                for (int i = 0; i < 3; i++) {
//                    executor.execute(new ConsumerFlow(producerThread, queue));
//                }
//                executor.shutdown();
//            }
//            if (future == null) {
//                future = executor.submit(new ConsumerFlow(producerThread, queue));
//            }
//        }
//
//        executor.shutdown();
}
