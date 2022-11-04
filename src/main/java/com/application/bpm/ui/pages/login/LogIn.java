package com.application.bpm.ui.pages.login;

import com.application.bpm.ui.base.UIActions;
import org.openqa.selenium.By;

public class LogIn extends UIActions {

    private static By textBox_Username = By.name("userName");
    private static By textBox_Password = By.name("password");
    private static By button_Submit = By.name("submit");

    public static void logInToBPMApplication() throws Exception {
        openURL(uiApplicationUrl);
        enterText(textBox_Username, uiUserName);
        enterText(textBox_Password, uiPassword);
        clickOnElement(button_Submit);
    }

    public static void logprint(String data) throws Exception {
        System.out.println(data);
    }
}
