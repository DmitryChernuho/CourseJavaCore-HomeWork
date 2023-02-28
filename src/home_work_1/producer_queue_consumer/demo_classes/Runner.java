package home_work_1.producer_queue_consumer.demo_classes;

import home_work_1.producer_queue_consumer.task_classes.Producer;
import home_work_1.producer_queue_consumer.task_classes.ThreadDataHelper;

public class Runner {
    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        ThreadDataHelper.producerThread = producerThread;
        producerThread.start();
    }
}
