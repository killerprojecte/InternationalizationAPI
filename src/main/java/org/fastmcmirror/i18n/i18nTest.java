package org.fastmcmirror.i18n;

public class i18nTest {
    public static void main(String[] args) {
        InternationalizationAPI zh_iapi = new InternationalizationAPI("1.19.2",MinecraftLanguage.zh_cn,System.getProperty("user.dir") + "/tmp/");
        InternationalizationAPI en_iapi = new InternationalizationAPI("1.19.2",MinecraftLanguage.en_us,System.getProperty("user.dir") + "/tmp/");
        System.out.println("zh_cn: " + zh_iapi.getItemName("diamond_sword"));
        System.out.println("zh_cn: " + zh_iapi.getEntityName("zombie"));
        System.out.println("en_us: " + en_iapi.getItemName("diamond_sword"));
        System.out.println("en_us: " + en_iapi.getEntityName("zombie"));
    }
}
