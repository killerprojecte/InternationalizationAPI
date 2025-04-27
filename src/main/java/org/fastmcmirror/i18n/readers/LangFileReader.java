package org.fastmcmirror.i18n.readers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LangFileReader implements LanguageReader {
    private final Properties props;
    public LangFileReader(String str) {
        props = new Properties();
        try {
            props.load(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
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
