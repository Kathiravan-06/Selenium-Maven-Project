
package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");

            System.out.println("Title: " + driver.getTitle());

            System.out.println("Google will remain open for 1 minute.");

            // Wait for 60 seconds
            for (int i = 60; i > 0; i--) {
                System.out.println("Time remaining: " + i + " seconds");
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted.");
            Thread.currentThread().interrupt();

        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
