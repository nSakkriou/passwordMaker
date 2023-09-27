package fr.nathansakkriou.passwordGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PasswordSaver {

    private String passwordFilePath;
    private ArrayList<String> passwordList;
    public PasswordSaver(String passwordFilePath) {
        this.passwordFilePath = passwordFilePath;
        this.passwordList = new ArrayList<>();
    }

    public void writePasswordInToFile(String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.passwordFilePath, true));
        writer.write("\n");
        writer.write(password);

        writer.close();
    }

    public void loadFilePassword() throws IOException{
        try {
            File myObj = new File(this.passwordFilePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                this.passwordList.add(myReader.nextLine());
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public String getPasswordFilePath() {
        return passwordFilePath;
    }

    public void setPasswordFilePath(String passwordFilePath) {
        this.passwordFilePath = passwordFilePath;
    }

    public ArrayList<String> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(ArrayList<String> passwordList) {
        this.passwordList = passwordList;
    }
}
