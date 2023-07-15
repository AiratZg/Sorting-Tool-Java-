package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Map;

public class Main {

    public static void main(String... args) throws FileNotFoundException {

        String sortType = "natural";
        String dataType = "word";
        String fileIn = "";
        String fileOut = "";
        Scanner sc;
        for (int i = 0; i < args.length; i++) {
            if ("-sortingType".equals(args[i])) {
                try {
                    sortType = args[i + 1];
                } catch (Exception e) {
                    System.out.println("No sorting type defined!");
                }
            }
            if ("-dataType".equals(args[i])) {
                try {
                    dataType = args[i + 1];
                } catch (Exception e) {
                    System.out.println("No data type defined!");
                }
            }
            if ("-inputFile".equals(args[i])) {
                try {
                    fileIn = args[i + 1];
                } catch (Exception e) {
                    System.out.println("No data type defined!");
                }
            }
            if ("-outputFile".equals(args[i])) {
                try {
                    fileOut = args[i + 1];
                } catch (Exception e) {
                    System.out.println("No data type defined!");
                }
            }
        }

        if (fileIn.equals("")) {
            sc = new Scanner(System.in);
        }
        else {
            File file = new File(fileIn);
            sc = new Scanner(file);
        }

        if (fileOut.equals("")) {
            switch (dataType) {
                case "word":
                    typeWord(sc, sortType);
                    break;
                case "long":
                    typeLong(sc, sortType);
                    break;
                case "line":
                    typeLine(sc, sortType);
                    break;
            }
        }
        else {
            File fOut = new File(fileOut);
            PrintWriter printWriter = new PrintWriter(fOut);
            switch (dataType) {
                case "word":
                    typeWord(sc, sortType,printWriter);
                    break;
                case "long":
                    typeLong(sc, sortType,printWriter);
                    break;
                case "line":
                    typeLine(sc, sortType,printWriter);
                    break;
            }
            printWriter.close();
        }
        sc.close();
}

    static void typeLong(Scanner sc, String sortType) {
        long total = 0;
        SortedMap<Long, Integer> values = new TreeMap<>();

        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            values.put(number, values.getOrDefault(number, 0) + 1);
            total += 1;
        }

        System.out.printf("Total numbers: %d.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            System.out.print("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(), Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }

    static void typeLong(Scanner sc, String sortType, PrintWriter printWriter) {
        long total = 0;
        SortedMap<Long, Integer> values = new TreeMap<>();

        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            values.put(number, values.getOrDefault(number, 0) + 1);
            total += 1;
        }

        printWriter.printf("Total numbers: %d.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            printWriter.print("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    printWriter.print(entry.getKey() + " ");
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> printWriter.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(),
                            Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }

    static void typeLine(Scanner sc, String sortType) {
        long total = 0;
        SortedMap<String, Integer> values = new TreeMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            values.put(line, values.getOrDefault(line, 0) + 1);
            total += 1;
        }

        System.out.printf("Total lines: %s.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            System.out.println("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.println(entry.getKey());
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(), Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }

    static void typeLine(Scanner sc, String sortType, PrintWriter printWriter) {
        long total = 0;
        SortedMap<String, Integer> values = new TreeMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            values.put(line, values.getOrDefault(line, 0) + 1);
            total += 1;
        }

        printWriter.printf("Total lines: %s.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            printWriter.println("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    printWriter.println(entry.getKey());
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> printWriter.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(),
                            Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }

    static void typeWord(Scanner sc, String sortType) {
        long total = 0;
        SortedMap<String, Integer> values = new TreeMap<>();

        while (sc.hasNext()) {
            String line = sc.next();
            values.put(line, values.getOrDefault(line, 0) + 1);
            total += 1;
        }

        System.out.printf("Total words: %s.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            System.out.printf("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(), Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }

    static void typeWord(Scanner sc, String sortType, PrintWriter printWriter) {
        long total = 0;
        SortedMap<String, Integer> values = new TreeMap<>();

        while (sc.hasNext()) {
            String line = sc.next();
            values.put(line, values.getOrDefault(line, 0) + 1);
            total += 1;
        }

        printWriter.printf("Total words: %s.%n", total);
        final long eftotal = total;

        if ("natural".equals(sortType)) {
            printWriter.printf("Sorted data: ");
            for (var entry : values.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    printWriter.print(entry.getKey() + " ");
                }
            }
        } else {
            values.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> printWriter.printf("%s: %d time(s), %d%%%n", entry.getKey(), entry.getValue(),
                            Math.round(entry.getValue() * 100.0 / eftotal)));
        }
    }
}
