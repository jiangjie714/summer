package com.jj.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jj.cloud.domain.Mat;
import com.jj.cloud.mapper.MatMapper;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private MatMapper matmapper;
	
	@Override
	public ArrayList<Mat> getList() {
		return  matmapper.getList();
	}

}
