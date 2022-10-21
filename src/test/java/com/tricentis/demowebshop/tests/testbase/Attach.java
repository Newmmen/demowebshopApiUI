package com.tricentis.demowebshop.tests.testbase;

public class Attach extends WebHelper {
    public static void addAttachments() {
        takeScreenShot();
        addPageSource();
        addVideo();
        if(System.getProperty("selenide.remote") != null) {
            addVideo();
        }
        browserConsoleLog();
    }
}
