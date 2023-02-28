package home_work_1.producer_queue_consumer.task_classes;

public class UserInputException extends RuntimeException {
    public UserInputException() {
        super("Number must be entered");
    }
}
