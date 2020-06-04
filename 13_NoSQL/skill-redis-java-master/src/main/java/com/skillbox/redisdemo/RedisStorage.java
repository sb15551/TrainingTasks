package com.skillbox.redisdemo;

import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

public class RedisStorage {
    public static final int USERS_COUNT = 20;

    private RedissonClient redissonClient;
    private RDeque<Integer> users;

    public void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Не удалось подключиться к Redis");
            System.out.println(Exc.getMessage());
        }
        users = redissonClient.getDeque("USERS");
        for (int i = 1; i <= USERS_COUNT; i++) {
            users.add(i);
        }
    }

    public RDeque<Integer> getUsers() {
        return users;
    }

    public void addLastUser(int userId) {
        users.addLast(userId);
    }

    public void pushUser(int userId) {
        users.push(userId);
    }

    public Integer peekFirstUser() {
        return users.peekFirst();
    }

    public Integer removeFirstUser() {
        return users.removeFirst();
    }

    public boolean removeUser(int userId) {
        return users.remove(userId);
    }
}
