// TransactionFileParser.java
package data;


import model.Transaction;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class TransactionFileParser {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void processTransactions(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(file -> parseAndWriteReport(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseAndWriteReport(Path file) {
        String reportLine = DATE_FORMAT.format(new Date()) + " - " + file.getFileName();
        try {
            List<Transaction> transactions = parse(file.toFile());
            reportLine += " - успешно обработан";
            System.out.println("1 - успешно обработан " + DATE_FORMAT.format(new Date()));
            System.exit(0);
        } catch (Exception e) {
            reportLine += " - ошибка во время обработки";
            System.out.println("2 - ошибка во время обработки");
        }

        try (FileWriter writer = new FileWriter("report.txt", true)) {
            writer.write(reportLine + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private List<Transaction> parse(File file) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Некорректный формат строки: " + line);
                }
                String fromAccount = parts[0].trim();
                String toAccount = parts[1].trim();
                int amount = Integer.parseInt(parts[2].trim());
                transactions.add(new Transaction(fromAccount, toAccount, amount));
            }
        }
        return transactions;
    }
}
