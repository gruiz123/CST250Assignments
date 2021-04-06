package edu.ru.assignment5;

import java.io.*;
import java.util.*;

public class MainClass{

   public static void main(String[] args) {
       try{
           
           File file = new File("happy.txt");

           BufferedReader br = new BufferedReader(new FileReader(file));
           String st;

           HashMap<String, Integer> map = new HashMap<String, Integer>();

           while ((st = br.readLine()) != null) {
           String[] arrOfStr = st.split(" ");

                   for (String a : arrOfStr){

                       if (map.containsKey(a)) {
           map.put(a, map.get(a) + 1);
           }
                       
           else {
                           map.put(a, 1);
           }
                   }
           }

           for (Map.Entry entry : map.entrySet()) {
   System.out.println(entry.getValue() + " :" + entry.getKey());
   }
       }
       catch(Exception e){
           System.out.print("Exception Occured!");
       }
   }
}
