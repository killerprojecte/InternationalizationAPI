package org.fastmcmirror.i18n;

import com.google.gson.annotations.SerializedName;

public class Version {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("time")
    private String time;

    public String getId() {
        return id;
    }

    public VersionType getType() {
        return VersionType.valueOf(type);
    }

    public String getUrl(){
        return url;
    }

    public String getTime() {
        return time;
    }
}
