package org.fastmcmirror.i18n.readers;

import java.io.*;
import java.util.Properties;

public class LangFileReader implements LanguageReader {
    private final Properties props;
    public LangFileReader(File file) {
        props = new Properties();
        try {
            props.load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean has(String key) {
        return props.containsKey(key);
    }

    @Override
    public String get(String key) {
        return props.getProperty(key);
    }
}
