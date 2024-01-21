import data.TransactionFileParser;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект TransactionFileParser
        TransactionFileParser parser = new TransactionFileParser();

        // Обрабатываем файлы переводов
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Обработать файлы переводов, 0 - Выход");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите путь к директории:");
                    String directory = scanner.next();
                    parser.processTransactions(directory);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод");
            }

            File file = new File("File.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}}

