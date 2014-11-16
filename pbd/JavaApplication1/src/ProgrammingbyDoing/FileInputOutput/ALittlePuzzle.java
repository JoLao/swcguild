/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.FileInputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ALittlePuzzle {
    public static void main(String[] args) throws Exception {
//Note: This Assignment is somewhat broken. Using Scanner, you can't read a single character from a file.
//
//Open a file specified by the user. This file will contain a bunch of characters. You should read in each 
//character from the file, one character at a time. Display every third character on the screen. Throw the 
//other characters away.        
        
        Scanner keybd = new Scanner(System.in);
        System.out.print("Open which file: ");
        String inputFile = keybd.nextLine();
        
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        String record = "";
        while(in.hasNext()) {
            record = in.nextLine();
        }
        in.close();
        for (int i = 1; i <= record.length(); i++) {
            if (i % 3 == 0) {
                System.out.print(record.charAt(i-1));
            }
        }
        
    }
    
}
//public class CharacterHandler {
//    //Java 7 source level
//    public static void main(String[] args) throws IOException {
//        // replace this with a known encoding if possible
//        Charset encoding = Charset.defaultCharset();
//        for (String filename : args) {
//            File file = new File(filename);
//            handleFile(file, encoding);
//        }
//    }
//
//    private static void handleFile(File file, Charset encoding)
//            throws IOException {
//        try (InputStream in = new FileInputStream(file);
//             Reader reader = new InputStreamReader(in, encoding);
//             // buffer for efficiency
//             Reader buffer = new BufferedReader(reader)) {
//            handleCharacters(buffer);
//        }
//    }
//
//    private static void handleCharacters(Reader reader)
//            throws IOException {
//        int r;
//        while ((r = reader.read()) != -1) {
//            char ch = (char) r;
//            System.out.println("Do something with " + ch);
//        }
//    }
//}
