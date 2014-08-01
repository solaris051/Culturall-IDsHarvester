package com.culturall.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.culturall.dao.IdDao;
import com.culturall.model.Page;
import com.culturall.model.TranslateId;
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
		Set<String> urlSet = harvester.getPageSet();
		Set<Page> pageSet = new HashSet<Page>();
		
		for (String url: urlSet) {
			Set<String> idsSet = null;
			try {
				idsSet = harvester.getTransIds(url);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			Page itPage = new Page();
			itPage.setUrl(url);
			itPage.setIds(new HashSet<TranslateId>());
			
			for (String curIdString: idsSet) {
				TranslateId curId = new TranslateId();
				curId.setTransId(Long.parseLong(curIdString));
				curId.setText("def. text");
				curId.setPage(itPage);
				itPage.getIds().add(curId);
			}
			pageSet.add(itPage);
			System.out.println("found " + itPage.getIds().size() + " ids on url " + itPage.getUrl());
		}
		
		System.out.println("Total number of pages scanned: " + pageSet.size());
		
		idDao.persistPages(pageSet);
		
	}
	
/*	
	@Scheduled(fixedDelay=3000)
	public void doSmth() {
		System.out.println("cron job running...");
	}
	*/
}
