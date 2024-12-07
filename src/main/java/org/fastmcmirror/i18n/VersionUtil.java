package org.fastmcmirror.i18n;

import com.google.gson.*;

import java.util.HashMap;
import java.util.Map;

public class VersionUtil {
    private final Map<String, Version> versions;

    protected VersionUtil(String savePath) {
        versions = new HashMap<>();
        long starttime = System.currentTimeMillis();
        String versionjson = Util.FileToString(Util.dlFile("https://bmclapi2.bangbang93.com/mc/game/version_manifest.json", "https://launchermeta.mojang.com/mc/game/version_manifest.json", savePath, "versions.json"));
        JsonObject vjo = new JsonParser().parse(versionjson).getAsJsonObject();
        VersionManifest manifest = new Gson().fromJson(vjo, VersionManifest.class);
        for (Version version : manifest.getVersions()) {
            version.put(version.getId(), version);
        }
        //System.out.println("Getting the version list took " + (System.currentTimeMillis() - starttime) + "ms");
    }

    public Version getVersion(String id) {
        return versions.get(id);
    }

    public boolean hasVersion(String id) {
        return versions.containsKey(id);
    }
}
