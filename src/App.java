/*
 * Yuepeng Xiong
 * 11/7/24
 * This program lets you make a password and will accept it if it contains at least 3 of the 4 requirements.
 * It will keep asking until it get what it wants.
 */


import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String password = "";
        String specialCharacters = "~!@#$%^&*()-=+_";
        String numbers = "0123456789"; 
        int countSetTrue = 0;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello new user!");
        System.out.println("Password must contain 8-16 characters and at least 3 of these 4 combinations: \nUppercase Letters \nLowercase Letters \nAny Numbers from 0-9 \nAny of the following special symbols: ~!@#$%^&*()-=+_ ");
        System.out.println("Please enter a new password: ");

        password = scanner.nextLine();
        password = password.trim(); //Trims whitespace from front and back of password

        //for when to keep asking for a password until a valid password is entered
        while (countSetTrue < 3) {
            // this is to reset the conditions when you enter an invalid password
            hasUppercase = false;
            hasLowercase = false;
            hasNumber = false;
            hasSpecial = false;
            countSetTrue = 0;

            // this is a simple way to checking if the password is upper or lowercase
            hasLowercase = !password.equals(password.toLowerCase());
            hasUppercase = !password.equals(password.toUpperCase());

            System.out.println("Has lowercase: " + hasLowercase);
            System.out.println("Has uppercase: " + hasUppercase);
            System.out.println("Password length: " + password.length());

            // First check the length of the password. If it's within 8-16, continue to analyze password:
            if (password.length() <= 16 && password.length() >= 8) {
                System.out.println("Password is within 8-16 characters");

                // Check if the password contains a special character:
                for (int i = 0; i < password.length(); i++) {
                    for (int j = 0; j < specialCharacters.length(); j++) {
                        if ((password.charAt(i) == specialCharacters.charAt(j))) {
                            hasSpecial = true;
                            System.out.println("Contained Special Character");
                        } // end if in for loop
                    } // end for loop for specialCharacters
                } // end for loop for password

                // Check for numbers
                for (int i = 0; i < password.length(); i++) {
                    for (int j = 0; j < numbers.length(); j++) {
                        if ((password.charAt(i) == numbers.charAt(j))) {
                            hasNumber = true;
                            System.out.println("Contained a Number");
                        } // end if in for loop
                    } // end for loop for numbers
                } // end for loop for password

                // Check how many booleans were true. Need 3 or more to pass:
                if (hasUppercase) {
                    countSetTrue++;
                }
                if (hasLowercase) {
                    countSetTrue++;
                }
                if (hasNumber) {
                    countSetTrue++;
                }
                if (hasSpecial) {
                    countSetTrue++;
                }

                if (countSetTrue >= 3) {
                    System.out.println("Password is valid.");
                } else {
                    System.out.println("Password is invalid. It must contain at least 3 of the 4 required combinations.");
                    System.out.println("Please enter a new password: ");
                    password = scanner.nextLine();
                    password = password.trim(); // Trims whitespace from front and back of password
                }//end if countset
            } else {
            System.out.println("Password must be within 8-16 characters");
            System.out.println("Please enter a new password: ");
            password = scanner.nextLine();
            password = password.trim(); // Trims whitespace from front and back of password
            } // end if for password length
        } // end while loop
    }//end main
}//end app
