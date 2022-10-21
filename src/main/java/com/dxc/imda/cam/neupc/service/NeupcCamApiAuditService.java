package com.dxc.imda.cam.neupc.service;

import org.springframework.stereotype.Service;

import com.dxc.imda.cam.neupc.entity.NeupcCamApiAudit;


@Service
public interface NeupcCamApiAuditService {
		
	public int saveOrUpdate(NeupcCamApiAudit neupcCamApiAudit);

}
