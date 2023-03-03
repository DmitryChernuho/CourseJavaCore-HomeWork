package home_work_1.producer_queue_consumer.task_classes;

public enum FilesData {
    LOG_FILE_DIR("./src/home_work_1/producer_queue_consumer/"),
    LOG_FILE_NAME("logFile.txt");

    private String fileData;

    FilesData(String fileData) {
        this.fileData = fileData;
    }

    public String getFileData() {
        return fileData;
    }
}
