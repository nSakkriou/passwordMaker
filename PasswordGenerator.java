package fr.nathansakkriou.passwordGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PasswordGenerator {
    private PasswordSaver passwordSaver;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetUpperCase;
    private String specialCharcter = "!#$%&'()*+,-.:;<=>?@[]^_`{|}~";
    private String numbers = "0123456789";

    public PasswordGenerator(){
        this.alphabetUpperCase = this.alphabet.toUpperCase();
        this.passwordSaver = new PasswordSaver(Config.passwordFilePath);
    }

    public String build(int passwordLength, boolean specialChar, boolean number, boolean upperCaseLetter){
        String possibilitesString = this.alphabet;
        if(specialChar){
            possibilitesString += this.specialCharcter;
        }

        if(number){
            possibilitesString += this.numbers;
        }

        if(upperCaseLetter){
            possibilitesString += this.alphabetUpperCase;
        }

        String password =  this.generate(passwordLength, possibilitesString);

        try {
            this.passwordSaver.writePasswordInToFile(password);
        } catch (IOException e) {
            System.out.println("Erreur lors du saving dans le fichier");
        }

        return password;
    }

    public String generate(int passwordLength, String possibilitesString){

        Random r = new Random();
        String password = "";
        for(int i = 0; i < passwordLength; i++){
            int id = r.nextInt(possibilitesString.length());
            password += possibilitesString.charAt(id);
        }

        return password;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabetUpperCase() {
        return alphabetUpperCase;
    }

    public void setAlphabetUpperCase(String alphabetUpperCase) {
        this.alphabetUpperCase = alphabetUpperCase;
    }

    public String getSpecialCharcter() {
        return specialCharcter;
    }

    public void setSpecialCharcter(String specialCharcter) {
        this.specialCharcter = specialCharcter;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public PasswordSaver getPasswordSaver() {
        return passwordSaver;
    }

    public void setPasswordSaver(PasswordSaver passwordSaver) {
        this.passwordSaver = passwordSaver;
    }
}
