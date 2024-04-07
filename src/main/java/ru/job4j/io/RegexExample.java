package ru.job4j.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        /**Pattern pattern = Pattern.compile("Я учусь на Job4j");

         String textOne = "Я учусь на Job4j";
         Matcher matcherOne = pattern.matcher(textOne);
         boolean isPresentOne = matcherOne.matches();
         System.out.println(isPresentOne);

         String textTwo = "Я учусь на курсе Job4j";
         Matcher matcherTwo = pattern.matcher(textTwo);
         boolean isPresentTwo = matcherTwo.matches();
         System.out.println(isPresentTwo);*/

        /** Pattern pattern = Pattern.compile("Job4j");

         String textOne = "Job4j";
         Matcher matcherOne = pattern.matcher(textOne);
         boolean isPresentOne = matcherOne.matches();
         System.out.println(isPresentOne);

         String textTwo = "job4j";
         Matcher matcherTwo = pattern.matcher(textTwo);
         boolean isPresentTwo = matcherTwo.matches();
         System.out.println(isPresentTwo);*/

        /** Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

         String textOne = "Job4j";
         Matcher matcherOne = pattern.matcher(textOne);
         boolean isPresentOne = matcherOne.matches();
         System.out.println(isPresentOne);

         String textTwo = "joB4J";
         Matcher matcherTwo = pattern.matcher(textTwo);
         boolean isPresentTwo = matcherTwo.matches();
         System.out.println(isPresentTwo);*/

        /**Pattern pattern = Pattern.compile("Job4j");

         String textOne = "Job4j";
         Matcher matcherOne = pattern.matcher(textOne);
         boolean isPresentOne = matcherOne.matches();
         System.out.println(isPresentOne);

         String textTwo = "job4j";
         Matcher matcherTwo = pattern.matcher(textTwo);
         boolean isPresentTwo = matcherTwo.matches();
         System.out.println(isPresentTwo);*/

        /**Pattern pattern = Pattern.compile("Job4j");
         String text = "Я учусь на курсе Job4j";
         Matcher matcher = pattern.matcher(text);
         boolean isPresent = matcher.find();
         System.out.println(isPresent);*/

        /**Pattern pattern = Pattern.compile("Job4j");
         String text = "Job4j и Job4j и Job4j";
         Matcher matcher = pattern.matcher(text);
         while (matcher.find()) {
         System.out.println("Найдено совпадение");
         }*/

       /** Pattern pattern = Pattern.compile("Job4j");
        String text = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }*/

        Pattern pattern = Pattern.compile("Job4j");
        String text = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher.start()
                    + " iEnd: " + matcher.end());
        }

        /**Pattern pattern = Pattern.compile("123");
        String text = "1231 и 1232 и 1233";
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("Job4j");
        System.out.println(result);*/
    }
}

