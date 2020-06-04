package ru.skillbox.module04_6.task01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Other {
    public static void main(String[] args) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy EEEE");
        LocalDate dateBirth = LocalDate.of(1988, 12, 12);
        LocalDate currentDate = LocalDate.now();

        System.out.println("Мой день рождения: " + dateFormat.format(dateBirth));
        int numberBirthDay = 0;
        for (dateBirth.getYear(); dateBirth.getYear() < currentDate.getYear(); dateBirth = dateBirth.plusYears(1)) {
            System.out.println(numberBirthDay + " - " + dateFormat.format(dateBirth));
            numberBirthDay++;
        }
    }
}
