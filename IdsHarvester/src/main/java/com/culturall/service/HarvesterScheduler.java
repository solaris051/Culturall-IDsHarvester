package com.culturall.service;

import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;

public class HarvesterScheduler {
	private static Logger logger = Logger.getLogger("Scheduler Bean");

	public HarvesterScheduler () {
		logger.info("Scheduler initialized");
	}
	
	@Scheduled(fixedDelay=3000)
	public void doYourThang() {
		logger.info("scheduler working!!!");
	}
}
