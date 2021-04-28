package edu.ru.finalproject;

import java.util.Scanner;

public class GradeBook {

   public static void main(String[] args) {

       String[] students = new String[5];

       char[] grades = new char[5];

       int[][] marks = new int[5][4];

       Scanner in = new Scanner(System.in);

       for (int i = 0; i < 5; i++) {


           System.out.println("Enter student name");

           students[i] = in.next();

           int sum = 0;


           for (int j = 0; j < 4; j++) {

               System.out.println("Enter marks for " + students[i] + " for test" + (j + 1));

               marks[i][j] = in.nextInt();


               while (marks[i][j] < 0 || marks[i][j] > 100) {

                   System.out.println("Invalid marks! marks should be >=0 and <=100");

                   marks[i][j] = in.nextInt();

               }


               sum += marks[i][j];

           }


           int avg = sum / 4;


           if (avg >= 90)

               grades[i] = 'A';

           else if (avg >= 80)

               grades[i] = 'B';

           else if (avg >= 70)

               grades[i] = 'C';

           else if (avg >= 60)

               grades[i] = 'D';

           else

               grades[i] = 'E';

       }


       System.out.println("Student Name\tgrades");

       for (int i = 0; i < 5; i++)

           System.out.println(students[i] + "\t\t\t" + grades[i]);

   }

}
