package home_work_1.producer_queue_consumer.task_classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class FileUtil {
    private final File logFile;

    public FileUtil(String fileName) {
        logFile = new File(FilesData.LOG_FILE_DIR.getFileData() + fileName);
    }

    public void logSleepStatusInFile(String text) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            fileWriter.write(String.format("%s - %s - %s\n",
                    timestamp.getTime(), Thread.currentThread().getName(), text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
