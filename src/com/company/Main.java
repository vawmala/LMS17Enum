package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Vincient","87roof","Victor",RoleEmployee.DIRECTOR);
        users[1] = new User("Voryag","321cat991","Elena",RoleEmployee.ADMINISTRATOR);
        users[2] = new User("Uzbek","87999555!","Tolik",RoleEmployee.CLIENT);
        users[3] = new User("Ovchar","854777895","Vadim",RoleEmployee.MANAGER);
        users[4] = new User("Volkodav","pelmen035","Pasha",RoleEmployee.ANONYMOUS);

        Store store = new Store("Kolbaska","https://kolbaska.com.ua/",users);

        do {
            tryLogin(store);
        } while (true);


    }
    static void tryLogin (Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        boolean answer = store.login(login,password);
        if (answer) {
            store.getCurrentUserRights();
            store.logout();
        } else {
            System.out.println("Неверный логин и/или пароль");
        }
    }
}
