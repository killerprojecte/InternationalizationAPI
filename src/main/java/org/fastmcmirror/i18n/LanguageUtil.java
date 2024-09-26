package org.fastmcmirror.i18n;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LanguageUtil {
    private JsonObject langJson;

    public LanguageUtil(Version version, String savePath, MinecraftLanguage language) {
        long starttime = System.currentTimeMillis();
        String json = Util.FileToString(Util.dlFile(version.getUrl().replaceFirst("https://piston-meta.mojang.com", "https://bmclapi2.bangbang93.com"), version.getUrl(), savePath, version.getId() + ".json"));
        JsonObject versionjo = new JsonParser().parse(json).getAsJsonObject();
        if (language.equals(MinecraftLanguage.en_us)) {
            String url = versionjo.get("downloads").getAsJsonObject().get("client").getAsJsonObject().get("url").getAsString();
            File jar = Util.dlFile(url.replaceFirst("https://piston-data.mojang.com", "https://bmclapi2.bangbang93.com"), url, savePath, version.getId() + "-client.jar");
            try {
                JarFile jarFile = new JarFile(jar);
                JarEntry entry = jarFile.getJarEntry("assets/minecraft/lang/en_us.json");
                langJson = new JsonParser().parse(Util.FileToString(Util.tofile(jarFile.getInputStream(entry), savePath, "en_us.json"))).getAsJsonObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        String url = versionjo.get("assetIndex").getAsJsonObject().get("url").getAsString();
        String js = Util.FileToString(Util.dlFile(url.replaceFirst("https://piston-meta.mojang.com", "https://bmclapi2.bangbang93.com"), url, savePath, version.getId() + "-assets.json"));
        JsonObject object = new JsonParser().parse(js).getAsJsonObject().get("objects").getAsJsonObject();
        for (String key : object.keySet()) {
            if (!key.equals("minecraft/lang/" + language + ".json")) continue;
            JsonObject langobj = object.get(key).getAsJsonObject();
            String hash = langobj.get("hash").getAsString();
            String path = hash.substring(0, 2) + "/" + hash;
            String ljson = Util.FileToString(Util.dlFile("https://bmclapi2.bangbang93.com/assets/" + path, "https://resources.download.minecraft.net/" + path, savePath, language + ".json"));
            JsonObject lang = new JsonParser().parse(ljson).getAsJsonObject();
            langJson = lang;
        }
        //System.out.println("Initializing languages took " + (System.currentTimeMillis() - starttime) + "ms");
    }

    public JsonObject getLanguage() {
        return langJson;
    }

    public boolean hasLanguage(MinecraftLanguage language) {
        return langJson != null;
    }
}
