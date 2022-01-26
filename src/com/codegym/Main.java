package com.codegym;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String YES = "y";
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên file nguồn: ");
        String inputFileName = sc.nextLine();

        if (!fileExist(inputFileName)) {
            System.out.println("File không tồn tại!");
        } else {
            System.out.print("Nhập tên file đích: ");
            String outputFileName = sc.nextLine();

            String confirm = YES;
            if (fileExist(outputFileName)) {
                System.out.print("File đã tồn tại. Bạn có muốn ghi đè file này <Y/N>?");
                confirm = sc.next().toLowerCase();
            }

            if (confirm.equals(YES)) {
                copyFile(inputFileName, outputFileName);
            }
        }


    }

    public static boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public static void copyFile(String inputFileName, String outputFileName) {
        try {
            InputStream fis = new FileInputStream(inputFileName);
            OutputStream fos = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
