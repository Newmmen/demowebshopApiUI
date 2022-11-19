package com.tricentis.demowebshop.tests.attach;

public class Attach extends WebHelper {
    public static void addAttachments() {
        takeScreenShot();
        addPageSource();
        if(System.getProperty("selenide.remote") != null) {
            addVideo();
        }
        browserConsoleLog();
    }
}
