package com.example.login;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.MainActivity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//public class Utilities {

  // public static Utilities getInstance() {
 //   }

    //public boolean validatePassword(SignUpActivity signUpActivity, String password) {
 //   }


    public class UtilitiesClass {
        //singleton instance
        private static UtilitiesClass instance;

        //c'tor
        public UtilitiesClass() {

        }

        public static UtilitiesClass getInstance() {
            if (instance == null)
                instance = new UtilitiesClass();
            return instance;
        }

        public boolean validatePassword(AppCompatActivity activity, String passowrd) {
            //password length min 8 , max 30
            if (!(passowrd.length() > 8 && passowrd.length() <= 30)) {
                Toast.makeText(activity, "Incorrect Username or password", Toast.LENGTH_SHORT).show();
                return false;
            }
            //min 1 capital , 1 small , 1 number
            int numbercount = 0;
            int capitalCount = 0;
            int smallCount = 0;
            int wildCardCount = 0;

            for (int i = 0; i <= passowrd.length(); i++) {
                if (passowrd.charAt(i) >= '0' && passowrd.charAt(i) <= '9') {
                    numbercount++;
                }
                if (passowrd.charAt(i) >= 'a' && passowrd.charAt(i) <= 'z') {
                    smallCount++;
                }
                if (passowrd.charAt(i) >= 'A' && passowrd.charAt(i) <= 'Z') {
                    capitalCount++;
                }
                if (passowrd.charAt(i) >= 33 && passowrd.charAt(i) <= 64) {
                    wildCardCount++;
                }

                if (!(numbercount >= 1 && smallCount >= 1 && capitalCount >= 1 && wildCardCount >= 1)) {
                    Toast.makeText(activity, "Incorrect Username or password", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            return true;
        }

        public boolean validateEmail(AppCompatActivity activity, String email) {
//check if @ exists and you have only one
            String[] splitString = email.split("@");
            if (splitString.length != 2) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }
// checking username
            String userName = splitString[0].toLowerCase();
            int i;

            //check length min 3 char , max 70 chars
            if (!(userName.length() >= 3 && userName.length() <= 70)) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }
//check for no spaces and first character

            for (i = 0; i <= userName.length(); i++) {
                if (userName.charAt(i) == ' ') {
                    Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            if (!((userName.charAt(0) >= 'a' && userName.charAt(0) <= 'z') || userName.charAt(0) == '_')) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }

            //check the rest of then characters

            for (i = 1; i <= userName.length(); i++) {
                if (!((userName.charAt(i) >= 'a' && userName.charAt(i) <= 'z') ||
                        (userName.charAt(i) >= '0' && userName.charAt(i) <= '9') ||
                        userName.charAt(i) == '_' || userName.charAt(i) == '.')) {
                    Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            // checking domain
            String domain = splitString[1].toLowerCase();
            //checking first character
            if (!((domain.charAt(0) >= 'a' && domain.charAt(0) <= 'z') || domain.charAt(0) == '_' ||
                    (domain.charAt(0) >= '0' && domain.charAt(i) <= '9'))) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }

            //checking if the last character is a letter
            if (!(domain.charAt(domain.length() - 1) >= 'a' && domain.charAt(domain.length() - 1) <= 'z')) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }
            //check if there's min 1 dor , max 3 dots using split
            String[] DomainSplit = domain.split(".");
            if (!(DomainSplit.length >= 2 && DomainSplit.length <= 4)) {
                Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                return false;
            }

            // check if the last dot split is letter
            int last = DomainSplit.length - 1;
            String LastPartOfDomain = DomainSplit[last];
            for (i = 0; i <= LastPartOfDomain.length(); i++) {
                if (!(LastPartOfDomain.charAt(i) >= 'a' && LastPartOfDomain.charAt(i) <= 'z')) {
                    Toast.makeText(activity, "Incorrect Username or passowrd", Toast.LENGTH_SHORT).show();
                    return false;

                }
                return true;
            }
        }
    }


