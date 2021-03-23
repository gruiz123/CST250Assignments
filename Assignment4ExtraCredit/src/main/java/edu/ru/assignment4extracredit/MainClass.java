package edu.ru.assignment4extracredit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainClass {

    public static void main(String[] args) throws IOException {

        System.out.println(getRandomWord("C:\\Users\\Jerry\\CST250Assignments\\Assignment4ExtraCredit\\names.txt"));
    }

    public static String getRandomWord(String path) throws IOException {
        List<String> words = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordline = line.split("\\s+");
                for (String word : wordline) {
                    words.add(word);
                }
            }
        }
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}
