package fr.nathansakkriou.passwordGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputPassword inputPassword = new InputPassword();
        System.out.println(inputPassword.run());

        inputPassword.getPasswordGenerator().getPasswordSaver().loadFilePassword();
        System.out.println(inputPassword.getPasswordGenerator().getPasswordSaver().getPasswordList());
    }
}
