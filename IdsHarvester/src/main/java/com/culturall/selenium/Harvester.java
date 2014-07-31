package com.culturall.selenium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.culturall.selenium.util.CultUtils;


public class Harvester {
	
	private Logger logger = Logger.getLogger(TestLauncher.class.getName());	
	private FirefoxDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) throws InterruptedException {
		Harvester harvester = new Harvester();
		Set<String> totalIds = new HashSet<String>();		
		Set<String> pagesToVisit = harvester.getPageSet();
		for (String s: pagesToVisit) {
			totalIds.addAll(harvester.getTransIds(s));
		}		
		
		System.out.println("totally IDs found: <<" + totalIds.size() + ">>");
		//close browser
		harvester.driver.close();
	}

	//open home page and go to opera repertoire
	private String openStopPage(String url) {
		driver.get(url);
		ArrayList<WebElement> venues = (ArrayList<WebElement>) driver.findElements(By.className("upcoming_performance_content"));
		
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
		logger.info("clicking State Opera");
		stateOpera.click();
		return driver.getCurrentUrl();	
	}
	
	//extracts IDs from specific page
	public Set<String> getTransIds(String url) throws InterruptedException {

		//set to language_debug=1;
		Thread.sleep(5000L);
		logger.info("turning debug mode ON");
		//driver.get(CultUtils.turnLangDebugOn(driver.getCurrentUrl()));
		driver.get(CultUtils.turnLangDebugOn(url));
		
		//find all placeholders
		String pageSource = driver.findElementByTagName("html").getAttribute("innerHTML");
		
		Pattern p = Pattern.compile("/admin/translation.mc\\?wort_id=\\d+&");
		Matcher m = p.matcher(pageSource);
		
		Set<String> translateIdSet = new HashSet<String>();
		
		while (m.find()) {
			String idMatch = m.group();			
			Pattern p2 = Pattern.compile("\\d+");
			Matcher m2 = p2.matcher(idMatch);
			
			if (m2.find()) {
				idMatch = m2.group();
			}
			
			translateIdSet.add(idMatch);
		}
		
		logger.info("turning debug mode OFF");
		
		//turn debug mode OFF
		Thread.sleep(3000L);;
		driver.get(CultUtils.turnLangDebugOff(driver.getCurrentUrl()));
		
		return translateIdSet;
	}
	
	//list of pages to harvest id's at
	public Set<String> getPageSet () {
		Set<String> pageList = new HashSet<String>();
	
		//performances
		pageList.add("https://www.culturall.com/ticket/btv/performance_schedule.mc?type=venues&haus_bez=WIENER%20STAATSOPER&haus_bez=Gustav%20Mahler%20-%20Saal%20Wr.%20Staatsoper&haus_bez=Staatsoper%20f%C3%BCr%20Kinder&haus_bez=Staatsoper%20Live-%C3%9Cbertragung&haus_bez=Staatsoper%20Video%20on%20Demand&haus_bez=Culturall-Gutschein");
		pageList.add("https://www.culturall.com/ticket/btv/performance_search.mc");
		pageList.add("https://www.culturall.com/ticket/btv/performance_schedule.mc");
		pageList.add("https://www.culturall.com/ticket/btv/bonuspunkte_aktion.mc");
		
		//subscription
		pageList.add("https://www.culturall.com/ticket/btv/subscription_index.mc");
		pageList.add("https://www.culturall.com/ticket/btv/subscription/schedule.mc");
		pageList.add("https://www.culturall.com/ticket/btv/performance_subscription.mc");
		pageList.add("https://www.culturall.com/contact_form.mc");

		return pageList;
	}
}