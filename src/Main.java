import main.java.concurrency.ProducerFlow;
import main.java.concurrency.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Thread producerThread = new Thread(new ProducerFlow(queue));
        producerThread.start();
        ThreadUtil.openThreadsForEvenQueueElement(producerThread, queue, 3);
    }
}