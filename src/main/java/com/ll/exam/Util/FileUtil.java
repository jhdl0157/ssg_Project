package com.ll.exam.Util;

import com.ll.exam.Post;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileUtil {
    public static void mkdir(String path) {
        File dir = new File(path);
        dir.mkdirs();
    }

    public static String getFilePath(){
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath()+"\\src\\main\\java\\com\\ll\\exam\\data";
        return path;
    }
    public static int getMaxNumberFileName(final String[] files) {
        return Arrays.stream(files).mapToInt(file -> Integer.parseInt(file.replace(".json", "").trim()))
                .max().orElse(0);
    }
    public static void fileWrite(File file, Post post) {
        System.out.println("fileWrite 진입 ");
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(post.toString());
            fileWriter.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
