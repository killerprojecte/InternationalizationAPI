package org.fastmcmirror.i18n;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Util {
    public static String FileToString(File file){
        String con = null;
        try {
            con = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static File dlFile(String url, String savePath, String saveName){
        File file = new File(savePath + "/" + saveName);
        if (url==null){
            return file;
        }
        if (file.exists()) return file;
        try {
            URLConnection connection;
            connection = new URL(url).openConnection();
            connection.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.0.0 Safari/537.36");
            connection.setConnectTimeout(3*1000);
            connection.connect();
            InputStream ins = connection.getInputStream();
            Path target = file.toPath();
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static File tofile(InputStream inputStream,String savePath,String saveName) throws IOException {
        File file = new File(savePath + "/" + saveName);
        if (file.exists()) return file;
        Path target = file.toPath();
        Files.createDirectories(target.getParent());
        Files.copy(inputStream, target, StandardCopyOption.REPLACE_EXISTING);
        return file;
    }
}
