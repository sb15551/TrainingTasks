package ru.skillbox.module09_3.task01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovementList {
    private static String path = "module09/src/main/resources/movementList.csv";
    public static void main(String[] args) {
        try {
            List<String[]> transaction = new ArrayList<>(parseFile(path));      // Парсим файл
            List<String[]> income = new ArrayList<>(getIncome(transaction));    // Транзакции дохода
            List<String[]> cost = new ArrayList<>(getCosts(transaction));       // Транзакции расхода
            List<String[]> costBreak = new ArrayList<>(costBreakDown(cost));    // Разбивка по контрагентам

            income.stream()
                    .map(t -> Double.parseDouble(t[1]))
                    .reduce((l1, l2) -> l1 + l2)
                    .ifPresent(s -> System.out.println("Сумма доходов: " + s));

            double sumCosts = cost.stream()
                    .mapToDouble(t -> Double.parseDouble(t[1]))
                    .sum();
            System.out.println("Сумма расходов: " + sumCosts);

            System.out.println("---------------------------------------- Вывод разбивки расходов ----------------------------------------");

            costBreak.forEach(t -> System.out.println(t[0] + "\t-\t" + t[1]));
            double sum = costBreak.stream()
                    .mapToDouble(s -> Double.parseDouble(s[1]))
                    .sum();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> costBreakDown(List<String[]> transactionCosts) {
        List<String[]> costsBreakDown = new ArrayList<>();
        List<String[]> temp = new ArrayList<>();
        temp.addAll(transactionCosts);
        double sum = 0.0;
        int count;
        for (int i = 0; i < temp.size() - 1; i++) {
            count = 1;
            sum = Double.parseDouble(temp.get(i)[1]);
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i)[0].equals(temp.get(j)[0])) {
                    sum += Double.parseDouble(temp.get(j)[1]);
                    count++;
                    temp.add(j, new String[]{"", "0"});
                    temp.remove(j + 1);
                }
            }
            if (count == 1) {
                costsBreakDown.add(new String[]{temp.get(i)[0], Double.toString(sum)});
                temp.add(i, new String[]{"", "0"});
                temp.remove(i + 1);
                sum = 0;
            }
            if (!temp.get(i)[0].equals("") && count > 1) {
                costsBreakDown.add(new String[]{temp.get(i)[0], Double.toString(sum)});
                temp.add(i, new String[]{"", "0"});
                temp.remove(i + 1);
                sum = 0;
            }
        }
        return costsBreakDown;
    }

    private static List<String[]> parseFile(String path) throws IOException {
        List<String[]> movementList = new ArrayList<>();
        List<String> transactions = Files.readAllLines(Paths.get(path));
        transactions.remove(0);
        transactions.stream()
                .map(t -> t = t.replaceAll("\"+", ""))
                .forEach(t -> movementList.add(t.split(",")));

        movementList.stream()
                .filter(t -> t.length > 8)
                .forEach(t -> t[t.length - 2] += "." + t[t.length - 1]);
        return movementList;
    }

    private static List<String[]> getIncome(List<String[]> movementList) {
        ArrayList<String[]> incomes = new ArrayList<>();
        movementList.stream()
                .filter(m -> Integer.parseInt(m[6]) > 0)
                .map(m -> new String[]{m[5].split("\\s{2,}")[2], m[6]})
                .forEach(incomes::add);
        return incomes;
    }

    private static List<String[]> getCosts(List<String[]> movementList) {
        ArrayList<String[]> costs = new ArrayList<>();
        movementList.stream()
                .filter(m -> Double.parseDouble(m[7]) > 0)
                .map(m -> new String[]{m[5].split("\\s{4,}")[1], m[7]})
                .forEach(costs::add);
        return costs;
    }
}
