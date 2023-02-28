package main.java.concurrency;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ProducerFlow implements Runnable {
    private final BlockingQueue<Integer> queueNumbers;

    public ProducerFlow(BlockingQueue<Integer> queueNumbers) {
        this.queueNumbers = queueNumbers;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String number;

        while (true) {
            number = scanner.next();
            try {
                if (number.matches("\\d+|(-1)")) {
                    if (number.contains("-1")) {
                        break;
                    }
                    queueNumbers.add(Integer.parseInt(number));
                    System.out.println(Arrays.toString(queueNumbers.toArray()));
                } else {
                    throw new UserInputException();
                }
            } catch (UserInputException e) {
                e.printStackTrace();
            }
        }
    }
}
