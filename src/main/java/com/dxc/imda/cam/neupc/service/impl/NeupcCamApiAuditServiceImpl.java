package com.dxc.imda.cam.neupc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.imda.cam.neupc.dao.NeupcCamApiAuditDao;
import com.dxc.imda.cam.neupc.entity.NeupcCamApiAudit;
import com.dxc.imda.cam.neupc.service.NeupcCamApiAuditService;

@Service
public class NeupcCamApiAuditServiceImpl implements NeupcCamApiAuditService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NeupcCamApiAuditDao neupcCamApiAuditDao;

	@Override
	public int saveOrUpdate(NeupcCamApiAudit tempNeupcCamApiAudit) {
		int result = 0;
		try {
			NeupcCamApiAudit neupcCamApiAudit = neupcCamApiAuditDao.save(tempNeupcCamApiAudit);
			result = neupcCamApiAudit != null ? 1 : 0;
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			result = 0;
		}		
		return result;
	}
}
