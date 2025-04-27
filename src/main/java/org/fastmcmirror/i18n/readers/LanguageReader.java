package org.fastmcmirror.i18n.readers;

public interface LanguageReader {
    boolean has(String key);
    String get(String key);
}
