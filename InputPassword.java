package fr.nathansakkriou.passwordGenerator;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class InputPassword {

    private int passwordLength;
    private boolean specialChar;
    private boolean upperCase;
    private boolean numbers;
    private PasswordGenerator passwordGenerator;

    public InputPassword(){
        this.passwordLength = 0;
        this.specialChar = true;
        this.upperCase = true;
        this.numbers = true;
        this.passwordGenerator = new PasswordGenerator();
    }

    public String run() throws IOException {
        System.out.println("Bienvenue dans le créateur de mot de passe");
        Scanner scanner = new Scanner(System.in);

        this.passwordLength = inputPasswordLength(scanner);


        if(!this.inputAllFeatures(scanner)){
            this.upperCase = inputUpperCase(scanner);
            this.numbers = inputNumbers(scanner);
            this.specialChar = inputSpecialChar(scanner);
        }

        return this.passwordGenerator.build(this.passwordLength, this.specialChar, this.numbers, this.upperCase);
    }

    public int inputPasswordLength(Scanner scanner){
        System.out.println("Quelles est la longeur du mot de passe ? :");

        try{
            int passwordLength = scanner.nextInt();
            scanner.nextLine();

            if(passwordLength < 4){
                throw new Exception();
            }

            return passwordLength;
        }
        catch (Exception e){
            System.out.println("Entrez une valeur correspondante (min supérieur à 3)");
            this.inputPasswordLength(scanner);
        }

        return -1;
    }

    public boolean inputAllFeatures(Scanner scanner){
        System.out.println("Voulez vous utiliser toutes les features (charcteres speciaux, majuscules, nombres) (oui|non) :");
        String input = scanner.nextLine();

        return checkBoolean(input);
    }

    public boolean inputSpecialChar(Scanner scanner){
        System.out.println("Voulez vous utiliser les charactères spéciaux ? (oui|non) :");
        String input = scanner.nextLine();


        return checkBoolean(input);
    }

    public boolean inputUpperCase(Scanner scanner){
        System.out.println("Voulez vous utiliser les charactères en majuscule ? (oui|non) :");
        String input = scanner.nextLine();


        return checkBoolean(input);
    }

    public boolean inputNumbers(Scanner scanner){
        System.out.println("Voulez vous utiliser les nombres ? (oui|non) :");
        String input = scanner.nextLine();


        return checkBoolean(input);
    }

    public boolean checkBoolean(String input){
        if(Objects.equals(input, "oui")){
            return true;
        }

        return false;
    }

    public PasswordGenerator getPasswordGenerator() {
        return passwordGenerator;
    }
}
