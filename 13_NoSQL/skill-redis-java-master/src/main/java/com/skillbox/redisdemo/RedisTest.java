package com.skillbox.redisdemo;

import org.redisson.api.RDeque;

import java.util.Random;

public class RedisTest {
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        RedisStorage rs = new RedisStorage();
        rs.init();

        while (true) {
            int everyTenth = 1;
            RDeque<Integer> users = rs.getUsers();
            for (int i = 1; i <= users.size(); i++) {
                System.out.println("На главной странице показываем пользователя " + users.getFirst());
                rs.addLastUser(rs.removeFirstUser());
                if (everyTenth % 10 == 0) {
                    int randomUser = random.nextInt(RedisStorage.USERS_COUNT) + 1;
                    System.out.println("Пользователь " + randomUser + " оплатил платную услугу");
                    rs.removeUser(randomUser);
                    rs.pushUser(randomUser);
                }
                everyTenth++;
                Thread.sleep(1000);
            }
        }
    }
}