import java.io.File;

import java.io.IOException;

import java.util.logging.Logger;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;


public class workWithFile {
    public static void main(String[] args) {   
        String json = logSome("file.txt");     
        System.out.println(json);
    }
        /*
    Создать метод, который запишет результат работы в файл.
    Обработайте исключения и запишите ошибки в лог файл
        */
    static String logSome (String filePath) {
        Logger log = getLog();

        File file = new File(filePath);

        StringBuilder sb = new StringBuilder();
        
        try (Scanner sc = new Scanner(file)){
            sb.append(sc.nextLine());
            log.info("Файл прочитан");
        } catch (IOException e) {
            log.warning(e.getMessage());
            e.printStackTrace();
        }
        return sb.toString();
        
        
    }

    static Logger getLog() {
        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
        
        return logger;
        
    }
}
