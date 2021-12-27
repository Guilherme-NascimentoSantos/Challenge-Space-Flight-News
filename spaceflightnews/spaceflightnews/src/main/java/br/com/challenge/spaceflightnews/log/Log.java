package br.com.challenge.spaceflightnews.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class Log {

    public void createLog(String message) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatOfDate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String dateFormated = formatOfDate.format(date);
        String nameFile = String.format("log %s.txt", dateFormated);
        BufferedWriter log = new BufferedWriter(new FileWriter(nameFile, true));

        log.append(String.format("error in synchronizing articles: \n\n%s", message));
        log.close();


    }
}
