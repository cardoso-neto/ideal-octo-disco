/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.bonigarcia.wdm.test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMars() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By searchInput = By.id("searchInput");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("geology of mars");
        By searchButton = By.id("searchButton");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        wait.until(textToBePresentInElementLocated(
            By.tagName("body"), "areology")
        );
    }
    
    @Test
    public void testByte() {
         driver.get("https://en.wikipedia.org/wiki/Main_Page");
         By searchInput = By.id("searchInput");
         wait.until(presenceOfElementLocated(searchInput));
         driver.findElement(searchInput).sendKeys("byte");
         By searchButton = By.id("searchButton");
         wait.until(elementToBeClickable(searchButton));
         driver.findElement(searchButton).click();
         wait.until(textToBePresentInElementLocated(
            By.tagName("body"), "Werner Buchholz")
        );
    }
    
    @Test
    public void testAmericanas() {
        driver.get("https://www.americanas.com.br/");
        By searchInput = By.id("h_search-input");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Notebook");
        By searchButton = By.id("h_search-btn");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        wait.until(textToBePresentInElementLocated(
            By.tagName("body"), "notebook")
        );
    }
}
