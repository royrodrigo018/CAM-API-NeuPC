package com.dxc.imda.cam.neupc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.imda.cam.neupc.entity.NeupcCamApiAudit;

@Repository
public interface NeupcCamApiAuditDao extends JpaRepository<NeupcCamApiAudit, Long> {
	
}
