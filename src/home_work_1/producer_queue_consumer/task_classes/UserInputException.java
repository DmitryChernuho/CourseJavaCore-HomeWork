package home_work_1.producer_queue_consumer.task_classes;

public class UserInputException extends IllegalArgumentException {
    public UserInputException(String message) {
        super(message);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInputException(Throwable cause) {
        super(cause);
    }
}
