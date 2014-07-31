package com.culturall.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.culturall.dao.IdDao;
import com.culturall.selenium.Harvester;

@Service
public class IdService {
	@Autowired IdDao idDao;
	
	public String getValue() {
		return idDao.getValue();
	}
	
	public void harvestIds () {
		System.out.println("in harvestIds method");
		Harvester harvester = new Harvester();
		Set<String> pageSet = harvester.getPageSet();
		
		for (String url: pageSet) {
			Set<String> idsSet = null;
			try {
				idsSet = harvester.getTransIds(url);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			idDao.persistIdsFromPage(idsSet, url);
		}
	}
	
/*	
	@Scheduled(fixedDelay=3000)
	public void doSmth() {
		System.out.println("cron job running...");
	}
	*/
}
