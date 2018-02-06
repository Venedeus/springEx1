package com.epam.spring;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Evgeniy_Shvetsov on 2/1/2018.
 */
public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    protected void init() throws IOException{
        this.file = new File(fileName);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event
                            .toString(),
                    Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
