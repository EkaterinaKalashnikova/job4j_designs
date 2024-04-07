package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException {
       /** Path directory = Paths.get("src/main/java/ru/job4j/io/path/paths");
        Files.createDirectories(directory);
        Path path = Path.of("src/main/java/ru/job4j/io/path/paths/path.txt");
        Files.createFile(path);
        File file = path.toFile();
        System.out.println(file);
        Path pathAgain = file.toPath();
        System.out.println(pathAgain);
        System.out.println("Файл/директория существует?: " + Files.exists(path));
        System.out.println("Это директория?: " + Files.isDirectory(path));
        System.out.println("Это файл?: " + Files.isRegularFile(path));
        System.out.println("Имя файла: " + path.getFileName());
        System.out.println("Путь к файлу абсолютный?: " + path.isAbsolute());
        System.out.println("Родительская директория файла: " + path.getParent());
        System.out.println("Абсолютный путь к файлу: " + path.toAbsolutePath());
        System.out.println("Абсолютный путь к директории: " + directory.toAbsolutePath());
        System.out.println("Доступен для чтения?: " + Files.isReadable(path));
        System.out.println("Доступен для записи?: " + Files.isWritable(path));
        Files.move(path, Path.of("src/main/java/ru/job4j/io/path/path1.txt"));
        Files.delete(directory);*/
        Path directory = Paths.get("src/main/java/ru/job4j/io/path/paths");
        /**Files.createDirectories(directory);*/
        Path target = Paths.get("src/main/java/ru/job4j/io/path");
        Path pathOne = Path.of("src/main/java/ru/job4j/io/path/paths/path1.txt");
        Files.createFile(pathOne);
        Path pathTwo = Path.of("src/main/java/ru/job4j/io/path/path2.txt");
        Files.createFile(pathTwo);
        DirectoryStream<Path> paths = Files.newDirectoryStream(target);
        paths.forEach(System.out::println);
    }
}
