package org.fastmcmirror.i18n.readers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;

public class JsonFileReader implements LanguageReader {
    private final JsonObject json;
    public JsonFileReader(String str) {
        json = new JsonParser().parse(str).getAsJsonObject();
    }
    @Override
    public boolean has(String key) {
        return json.has(key);
    }

    @Override
    public String get(String key) {
        return json.get(key).getAsString();
    }
}
