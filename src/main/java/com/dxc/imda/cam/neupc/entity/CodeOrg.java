package com.dxc.imda.cam.neupc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CODE_ORG")
public class CodeOrg implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CODE_ORG")
	@SequenceGenerator(name="CODE_ORG", sequenceName="SEQ_CODE_ORG", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@OneToMany(mappedBy = "codeOrg")
	private Set<UserProfile> userProfiles = new HashSet<>();

	@Column(name = "CODE_TYPE_VAL")
	private String codeTypeVal;

	@Column(name = "CODE_VAL")
	private String codeVal;

	@Column(name = "CODE_DES")
	private String codeDes;

	@Column(name = "ORG_TYPE")
	private String orgType;

	@Column(name = "SHORT_NAME")
	private String shortName;
	
	@Column(name = "STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public String getCodeTypeVal() {
		return codeTypeVal;
	}

	public void setCodeTypeVal(String codeTypeVal) {
		this.codeTypeVal = codeTypeVal;
	}

	public String getCodeVal() {
		return codeVal;
	}

	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}

	public String getCodeDes() {
		return codeDes;
	}

	public void setCodeDes(String codeDes) {
		this.codeDes = codeDes;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
