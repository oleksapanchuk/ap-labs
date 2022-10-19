package com.panchuk.taxes.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.panchuk.taxes.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class UserStorage {
    private static final String FILE_PATH = "data/users.json";
    private static List<User> users;

    static {
        jsonReader();
    }

    public static void addUser(User user) {
        users.add(user);

        jsonWriter();
    }

    public static User findUser(String login, String password) {
        List<User> u = users
                .stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).toList();
        if (u.isEmpty())
            return null;
        return u.get(0);
    }

    public static void jsonWriter() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonReader() {
        try (Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            Type foundListType = new TypeToken<List<User>>(){}.getType();
            users = new Gson().fromJson(reader, foundListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
