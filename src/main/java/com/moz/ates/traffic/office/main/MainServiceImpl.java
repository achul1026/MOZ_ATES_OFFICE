package com.moz.ates.traffic.office.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.operator.MozWebOprtr;
import com.moz.ates.traffic.common.repository.operator.MozWebOprtrRepository;


@Service
public class MainServiceImpl implements MainService {
	
    @Autowired
    MozWebOprtrRepository webOprtrRepository;
    
    @Override
    public MozWebOprtr getUserById(MozWebOprtr webOprtr) {
    	return webOprtrRepository.selectUserById(webOprtr);
    }
}
