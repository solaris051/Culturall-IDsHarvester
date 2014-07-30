package com.culturall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.culturall.dao.IdDao;

@Service
public class IdService {
	@Autowired IdDao idDao;
	
	public String getValue() {
		return idDao.getValue();
	}
	
	@Scheduled(fixedDelay=3000)
	public void doSmth() {
		System.out.println("cron job running...");
	}
}
