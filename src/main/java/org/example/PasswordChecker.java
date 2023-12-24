package org.example;

import java.util.regex.Pattern;

public class PasswordChecker {
    public int minLength;
    public int maxRepeats;
    private final Pattern PATTERN = Pattern.compile("(A+[\\s\\S]+z)");
    public PasswordChecker(int minLength, int maxRepeats) {
        this.minLength = minLength;
        this.maxRepeats = maxRepeats;
    }

    public boolean verify (String password) {
        boolean checkLength = password.length() >= minLength;
        boolean checkRepeats = correctRepeats(password);

        if (!checkLength && maxRepeats == 0) {
            throw new IllegalStateException("Должно быть выставлено 2 настройки");
        }
        return checkLength && checkRepeats;
    }

    public boolean correctRepeats(String password) {
        int errorRepeatsCount = maxRepeats + 1;
        for (int i = 0; i < password.length(); i++) {
            String pattern = Character.toString(password.charAt(i)).repeat(errorRepeatsCount);

            if (password.contains(pattern)) { return false; }
        }
        return true;
    }

    public boolean validatePass(String password){
        return PATTERN.matcher(password).matches();
    }
}
