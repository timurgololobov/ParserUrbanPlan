package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkWithFile {
    public static void writeToFile(String exportHTML){
        try {
            final Path pathForText = Paths.get("test.html"); //добавил
            byte[] bs = exportHTML.getBytes();
            Path writtenFilePath = Files.write(pathForText, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
