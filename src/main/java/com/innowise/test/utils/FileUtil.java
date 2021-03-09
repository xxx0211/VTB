package com.innowise.test.utils;

public class FileUtil {
    public static String getFileExtension(String filename){
        char letter;
        int i = filename.length() - 1;
        StringBuilder extension = new StringBuilder();
        while((letter = filename.charAt(i)) != '.'){
            extension.append(letter);
            i--;
        }

        return extension.reverse().toString();
    }

    public static boolean fileExtensionValidation(String fileExtension){
        return fileExtension.equals(".json");
    }
}
