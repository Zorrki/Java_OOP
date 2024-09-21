import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class FileLogger implements Loggable {
    private final Logger logger = Logger.getLogger("MyLog");

    public FileLogger() {
        setFileHandler("log.txt");
    }

    public FileLogger(String fileNameLog) {
        setFileHandler(fileNameLog);
    }

    public void setFileHandler(String fileNameLog) {
        this.logger.setUseParentHandlers(false);
        try {
            FileHandler fh = new FileHandler(fileNameLog, true);
            this.logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
        } catch (Exception e) {
            System.out.println("Ошибка работы с файлом.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void log(String msg) {
        logger.info(msg);
    }
}