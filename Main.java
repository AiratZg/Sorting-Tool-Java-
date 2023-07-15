package sorting;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String dataType = "word";
    private static String sortType = "natural";

    public static void main(final String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                if (i + 1 >= args.length || args[i + 1].equals("")) {
                    System.out.println("No sorting type defined!");
                } else {
                    sortType = args[i + 1];
                }
            } else if (args[i].equals("-dataType")) {
                if (i + 1 >= args.length || args[i + 1].equals("")) {
                    System.out.println("No data type defined!");
                } else {
                    dataType = args[i + 1];
                }
            } else if (args[i].contains("-")) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", args[i]);
            }
        }

        switch (dataType) {
            case "word" -> word();
            case "line" -> line();
            case "long" -> number();
        }
    }

    private static void sort(List<String> word) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : word) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        sortedMap.forEach((key, value) -> System.out.printf("%s: %d time(s), %d%%%n",
                key, value, value * 100 / map.size()));
    }

    private static void word() {
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        System.out.printf("Total words: %d.%n", words.size());
        Collections.sort(words);

        if ("byCount".equals(sortType)) {
            sort(words);
        } else {
            System.out.println("Sorted data: ");
            for (String word : words) {
                System.out.println(word + " ");
            }
        }
    }

    private static void number() {
        List<Long> numbers = new ArrayList<>();

        do {
            try {
                numbers.add(scanner.nextLong());
            } catch (Exception e) {
                System.err.println("Input value is not long type");
            }
        } while (scanner.hasNext());

        Collections.sort(numbers);
        System.out.printf("Total numbers: %d.%n", numbers.size());

        if ("byCount".equals(sortType)) {
            Map<Long, Long> map = new LinkedHashMap<>();
            for (Long num: numbers) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1L);
                }
            }

            Map<Long, Long> sortedMap = new LinkedHashMap<>();
            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            sortedMap.forEach((key, value) -> System.out.printf("%d: %d time(s), %d%%%n",
                    key, value, value * 100 / map.size()));
        } else {
            System.out.print("Sorted data: ");
            for (Long num: numbers) {
                System.out.print(num + " ");
            }
        }
    }

    private static void line() {
        List<String> lines = new ArrayList<>();

        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }

        Collections.sort(lines);
        System.out.printf("Total lines: %d.%n", lines.size());

        if ("byCount".equals(sortType)) {
            sort(lines);
        } else {
            System.out.print("Sorted data: ");
            for (String line: lines) {
                System.out.print(line + " ");
            }
        }
    }
}