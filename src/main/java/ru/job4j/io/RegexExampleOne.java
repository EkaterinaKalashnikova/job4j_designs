package ru.job4j.io;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExampleOne {
    public static void main(String[] args) {
        String string = "123+=-456:/789";
        String[] result = string.split("\\D+");
        System.out.println(Arrays.toString(result));

        /**Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        String text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }*/

        /**Pattern pattern = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
        String text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }*/

        Pattern pattern = Pattern.compile("\\S{1,}@\\S{1,}\\.\\S{1,}");
        String text = "peter-2022@example.com example65@mail_box.ru 123_45@example-mailbox.com";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }
    }
}
