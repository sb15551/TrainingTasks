package ru.skillbox.module04_6.task01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy EEEE");
        Date dateBirth = new Date(88, 11, 12);
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateBirth);
        System.out.println("Мой день рождения: " + dateFormat.format(calendar.getTime()));
        int numberBirthDay = 0;
        for (calendar.getTime(); calendar.getTime().compareTo(currentDate) < 0; calendar.add(Calendar.YEAR, 1)) {
            System.out.println(numberBirthDay + " - " + dateFormat.format(calendar.getTime()));
            numberBirthDay++;
        }
    }
}
