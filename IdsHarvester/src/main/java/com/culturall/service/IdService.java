package com.culturall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culturall.dao.IdDao;

@Service
public class IdService {
	@Autowired IdDao idDao;
	
	public String getValue() {
		return idDao.getValue();
	}
}
