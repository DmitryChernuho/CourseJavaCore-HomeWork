package home_work_1.producer_queue_consumer.task_classes;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements Runnable {
    @Override
    public void run() {
        System.out.println("Input number of consumers: ");
        Scanner scanner = new Scanner(System.in);
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        int numberOfConsumers = scanner.nextInt();
        for (int consumerNumber = 1; consumerNumber <= numberOfConsumers; consumerNumber++) {
            Consumer consumer = new Consumer(consumerNumber, queue, Thread.currentThread());
            consumer.start();
        }
        System.out.println("Input numbers: ");
        int number;
        while ((number = scanner.nextInt()) != -1) {
            try {
                queue.add(number);
            } catch (IllegalStateException exception) {
                throw new UserInputException("Number must be entered", exception);
            }
        }
    }
}
