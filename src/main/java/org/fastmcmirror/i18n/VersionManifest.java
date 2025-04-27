package org.fastmcmirror.i18n;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VersionManifest {
    @SerializedName("versions")
    private List<Version> versions;

    public List<Version> getVersions() {
        return versions;
    }
}
