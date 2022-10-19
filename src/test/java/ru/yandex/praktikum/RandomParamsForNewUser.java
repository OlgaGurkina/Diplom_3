package ru.yandex.praktikum;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomParamsForNewUser {

    private final int length = 6;
    private final boolean useLetters = true;
    private final boolean useNumbers = true;

    String generatedName;
    String generatedPassword;
    String generatedEmail;

    public void randomUserName(){
        this.generatedName = RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public void randomUserPass(){
        this.generatedPassword = RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public void randomUserEmail() {
        this.generatedEmail = "test_email+" + System.nanoTime() + "@yandex.ru";
    }
}
