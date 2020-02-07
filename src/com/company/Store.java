package com.company;

import java.util.Arrays;

public class Store {
    private String title;
    private String url;
    private User[] users;
    User userAuthorized;

    public Store(String title, String url, User[] users) {
        this.title = title;
        this.url = url;
        this.users = users;

    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public User[] getUsers() {
        return users;
    }

    public User getUserAuthorized() {
        return userAuthorized;
    }

    public boolean login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                userAuthorized = new User();
                userAuthorized.setLogin(user.getLogin());
                userAuthorized.setPassword(user.getPassword());
                userAuthorized.setName(user.getName());
                userAuthorized.role = user.role;
                return true;
            } else {
                System.out.println("Данный пользователь не авторизирован в нашей системе");


            }
        }
        return true;
    }

    public void getCurrentUserRights() {
        if (userAuthorized != null) {
            RoleEmployee role = userAuthorized.role;
            switch (role) {
                case DIRECTOR:
                    System.out.println("Директор магазина, может управлять кадрами, и ценами");
                    break;
                case ADMINISTRATOR:
                    System.out.println("Администратор магазина, может добавлять товары и редактировать их описание");
                    break;
                case MANAGER:
                    System.out.println("Менеджер магазина, может общаться с клиентами");
                    break;
                case CLIENT:
                    System.out.println("Клиент магазина, может покупать товары и пользоваться дисконтом");
                    break;
                case ANONYMOUS:
                    System.out.println("Анонимный пользователь, может покупать товары и или авторизоваться");
                    break;
            }
        } else {
            System.out.println("Данной записи нет в данном магазине ");
        }
    }


    public void logout() {
        userAuthorized = null;
        System.out.println("Пользователь вышел из системы");
    }
}


