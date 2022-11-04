package com.application.bpm.ui.base;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static Properties sqlProperties;
    public static String uiApplicationUrl;
    public static String uiUserName;
    public static String uiPassword;
    public static String dbURL;
    public static String dbUserName;
    public static String dbPassword;


    public static void loadFile() throws Exception {
        sqlProperties = new Properties();
        sqlProperties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/dbquery.properties"));
    }

    public static void loadAllUIAndDBParameters(String appURL, String appUserName, String appPassword, String dbURI, String dbUsername, String dbPassWord) throws Exception {
        loadFile();
        uiApplicationUrl = appURL;
        uiUserName = appUserName;
        uiPassword = appPassword;
        dbURL = dbURI;
        dbUserName = dbUsername;
        dbPassword = dbPassWord;
    }

}
