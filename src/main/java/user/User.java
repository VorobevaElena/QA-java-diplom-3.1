package user;

import java.util.Random;

public class User {
    private String email = "mail" + new Random().nextInt(10000) + "@yandex.ru";
    private String password = "pass" + new Random().nextInt(10000);
    private String name = "name" + new Random().nextInt(10000);
    public String getRandomName() {
        return this.name;
    }

    public  String getRandomEmail() {
        return this.email;
    }

    public  String getRandomPassword() {
        return this.password;
    }

}