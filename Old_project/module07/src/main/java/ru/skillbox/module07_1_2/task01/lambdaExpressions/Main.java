package ru.skillbox.module07_1_2.task01.lambdaExpressions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "D:\\java\\Gitlab_Skillbox\\module07\\src\\main\\java\\ru\\skillbox\\module07_1_2\\task01\\lambdaExpressions\\data\\staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();
        Collections.sort(staff, ((o1, o2) -> {
            int compare = o1.getSalary().compareTo(o2.getSalary());
            if (compare != 0) return compare;
            else return o1.getName().compareTo(o2.getName());
        }));
        for (Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println("----------------------- Максимальная зарплата с 2017 года -----------------------");
        Date startDate = new Date(117, 00, 01);
        Date finalDate = new Date(117, 11, 31);
        staff.stream().filter(employee -> employee.getWorkStart().after(startDate))
                .filter(employee -> employee.getWorkStart().before(finalDate))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}