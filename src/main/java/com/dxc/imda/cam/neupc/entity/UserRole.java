package com.dxc.imda.cam.neupc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USR_ROLE")
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seqUsrRole", sequenceName = "SEQ_USR_ROLE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsrRole")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="MODULENAME")
	private String moduleName;
	
	@Column(name="ROLE_CODE") 
	private String roleName; //for consistency with NORS, NEUPC and DAS

	@Column(name="ROLE_DESC")
	private String roleDesc;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name = "STATUS_DATE")
	private Date statusDate;

	@Column(name = "CREATED_TIME")
	private Date createdDate;
	
	@Column(name = "LAST_UPD_TIME")
	private Date lastUpdDate;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "LAST_UPD_BY")
	private String lastUpdBy;
	
	@Column(name = "LA_APP_TYPE")
	@JsonIgnore
	private String laAppType;
	
	@Column(name = "APPLICATION_ID")
	@JsonIgnore
	private String applicationId;
	
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRole")
	//private List<UserProfile> userProfiles = new ArrayList<UserProfile>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdBy() {
		return lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public String getLaAppType() {
		return laAppType;
	}

	public void setLaAppType(String laAppType) {
		this.laAppType = laAppType;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

//	public List<UserProfile> getUserProfiles() {
//		return userProfiles;
//	}
//
//	public void setUserProfiles(List<UserProfile> userProfiles) {
//		this.userProfiles = userProfiles;
//	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", moduleName=" + moduleName + ", roleName=" + roleName + ", roleDesc=" + roleDesc
				+ ", status=" + status + ", statusDate=" + statusDate + ", createdDate=" + createdDate
				+ ", lastUpdDate=" + lastUpdDate + ", createdBy=" + createdBy + ", lastUpdBy=" + lastUpdBy + "]";
	}	
}
