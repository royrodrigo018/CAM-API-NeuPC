package com.dxc.imda.cam.common.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dxc.imda.cam.common.constant.Constants;
import com.dxc.imda.cam.common.constant.Enums.ResourceType;
import com.dxc.imda.cam.neupc.entity.NeupcCamApiAudit;

public class AuditUtil {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public NeupcCamApiAudit logNeupcAudit(HttpServletRequest request, 
		HttpServletResponse response,
		ResourceType resourceType, Object object) {
		
		NeupcCamApiAudit neupcCamApiAudit = new NeupcCamApiAudit();
		if (resourceType.equals(ResourceType.USER)) {
			neupcCamApiAudit.setResource(ResourceType.USER.toString());
		}else {
			neupcCamApiAudit.setResource(ResourceType.GROUP.toString());
		}
		neupcCamApiAudit.setRequestUri(request.getRequestURI());		
		neupcCamApiAudit.setRequestDate(new Date());
		
		JSONUtil jsonUtil = new JSONUtil();
		String jsonString = jsonUtil.convertObjectToJsonString(object);
		neupcCamApiAudit.setData(jsonString);	
		
		logger.info("logNeupcAudit response.getStatus(): " + response.getStatus());
		neupcCamApiAudit.setResponseStatus(response.getStatus());
		neupcCamApiAudit.setStatus(Constants.SUCCESS);
		if (response.getStatus() >= 400) {
			neupcCamApiAudit.setStatus(Constants.ERROR);	
		}		
		return neupcCamApiAudit;
	}
}
