package home_work_1.producer_queue_consumer.task_classes;

import java.util.Scanner;

public class Producer implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String number;

        System.out.println("Input number of consumers: ");
        int numberOfConsumers = scanner.nextInt();
        for (int consumerNumber = 1; consumerNumber <= numberOfConsumers; consumerNumber++) {
            Consumer consumer = new Consumer(consumerNumber);
            consumer.start();
        }
        System.out.println("Input numbers: ");
        while (true) {
            number = scanner.next();
            if (number.matches("\\d+|(-1)")) {
                if (number.contains("-1")) {
                    break;
                }
                ThreadDataHelper.addNumber(Integer.parseInt(number));
            } else {
                throw new UserInputException();
            }
        }
    }
}
