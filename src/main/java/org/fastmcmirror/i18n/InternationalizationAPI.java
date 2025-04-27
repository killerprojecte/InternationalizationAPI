package org.fastmcmirror.i18n;

import com.google.gson.JsonObject;
import org.fastmcmirror.i18n.readers.LanguageReader;

public class InternationalizationAPI {
    private final VersionUtil versionUtil;

    private final LanguageUtil languageUtil;

    private final LanguageReader json;

    public InternationalizationAPI(String minecraftVersion, MinecraftLanguage language, String savePath) {
        versionUtil = new VersionUtil(savePath);
        languageUtil = new LanguageUtil(versionUtil.getVersion(minecraftVersion), savePath, language);
        json = languageUtil.getLanguage();
    }

    public VersionUtil getVersionUtil() {
        return versionUtil;
    }

    public LanguageUtil getLanguageUtil() {
        return languageUtil;
    }

    public LanguageReader getLanguageReader() {
        return json;
    }

    public String getCustomKey(String key) {
        if (json.has(key)) {
            return json.get(key);
        }
        return "";
    }

    public String getItemName(String type) {
        if (json.has("item.minecraft." + type.toLowerCase())) {
            return json.get("item.minecraft." + type.toLowerCase());
        } else if (json.has("block.minecraft." + type.toLowerCase())) {
            return json.get("block.minecraft." + type.toLowerCase());
        } else {
            return "";
        }
    }

    public String getEntityName(String type) {
        if (json.has("entity.minecraft." + type.toLowerCase())) {
            return json.get("entity.minecraft." + type.toLowerCase());
        } else {
            return "";
        }
    }
}
