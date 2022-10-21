package com.dxc.imda.cam.neupc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "USR_PROFILE")
public class UserProfile implements Serializable{

	private static final long serialVersionUID = -35027307322296379L;
		
	@Id
	@SequenceGenerator(name = "seqUsrProfile", sequenceName = "SEQ_USR_PROFILE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsrProfile")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERID")
	private String userId;
		
	@Column(name = "NAME")
	private String userName;
	
	@Column(name = "NRIC")
	private String nric;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "DESIGNATION")
	private String designation;	

	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "STATUS_DATE")
	private Date statusDate;	
	
	@Column(name = "LAST_ACCESS_DATE")
	private Date lastAccessDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_TIME")
	private Date createdDate;
	
	@Column(name = "LAST_UPD_BY")
	private String lastUpdBy;
	
	@Column(name = "LAST_UPD_TIME")
	private Date lastUpdDate;
	
//	@Column(name = "ORG_ID")
//	private String orgId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
	private UserRole userRole;
	
	@NotFound(action = NotFoundAction.IGNORE) 
	@ManyToOne
	@JoinColumn(name = "ORG_ID")
	private CodeOrg codeOrg;
	
	public UserProfile() {
		super();
	}

	public UserProfile(UserProfile userProfile) {
		super();
		this.id = userProfile.id;
		this.userId = userProfile.userId;	
		this.nric = userProfile.nric;		
		this.userName = userProfile.userName;		
		this.status = userProfile.status;
		this.email = userProfile.email;
		this.userType = userProfile.userType;
		this.designation = userProfile.designation;
		this.department = userProfile.department;
		this.statusDate = userProfile.statusDate;
		this.lastAccessDate = userProfile.lastAccessDate;
		this.createdBy = userProfile.createdBy;
		this.createdDate = userProfile.createdDate;
		this.lastUpdBy = userProfile.lastUpdBy;
		this.lastUpdDate = userProfile.lastUpdDate;
		this.userRole = userProfile.userRole;
		//this.orgId = userProfile.orgId;
		this.codeOrg = userProfile.codeOrg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public CodeOrg getCodeOrg() {
		return codeOrg;
	}

	public void setCodeOrg(CodeOrg codeOrg) {
		this.codeOrg = codeOrg;
	}	
}
