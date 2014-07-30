/*
	Test the Staatsoper ticket buying UC
*/
package com.culturall.selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLauncher {
	
	public static void main(String... args) {
		
		FirefoxDriver ffDriver = new FirefoxDriver();
		ffDriver.get("https://www.culturall.com");
		
		ArrayList<WebElement> venues = (ArrayList<WebElement>) ffDriver.findElements(By.className("upcoming_performance_content"));
		
		//find the State opera element
		WebElement stateOpera = null;
		for (WebElement we: venues) {
			if (we.getAttribute("href").indexOf("STAATSOPER") >= 0) {
				stateOpera = we;
				break;
			}
		}
		
		if (stateOpera == null) {
			throw new RuntimeException("no link with State Opera found");
		}
		
		//click link and go to performances view
		
		stateOpera.click();
		stateOpera = null;
		venues = null;
		
		//click the last month and scroll down
		WebElement monthMenu = ffDriver.findElementsByClassName("month_menu").get(0);
		if (monthMenu == null) {
			throw new RuntimeException("no month menues found");
		}
		
		ArrayList <WebElement> allMonths = (ArrayList<WebElement>) monthMenu.findElements(By.tagName("li"));
		allMonths.get(allMonths.size()-1).findElement(By.tagName("a")).click();
		
		
	}
}
