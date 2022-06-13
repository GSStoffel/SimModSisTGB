package src;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemLog {

    public static final String LOG_FILEPATH = "log.txt";

    private static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void writeInFile(String textToWrite){
        writeInFile(LOG_FILEPATH, textToWrite);
    }

    public static void writeInFile(String filepath, String textToWrite){
        try {
            File fileOut = new File(filepath);
            FileOutputStream fos = new FileOutputStream(fileOut, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String logText = getCurrentTime()+" >>> "+textToWrite;

            System.out.println(logText);
            System.out.println();

            bw.write(logText);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
