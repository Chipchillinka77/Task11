package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String text = readFile(args[0]);
            System.out.println("Отформатированный текст: ");
            System.out.println(getNewString(text));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (in.hasNext()) {
            buffer.append(in.nextLine());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    static String getNewString(String input) {
        char[] string = input.toCharArray();
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(') {
                int count = 0;

                do {
                    if (string[i] == ')') {
                        count--;
                    }
                    if (string[i] == '(') {
                        count++;
                    }
                    i++;
                } while (count != 0);

                i--;
            } else {
                builder.append(string[i]);
            }
        }
        return builder.toString();
    }
}
