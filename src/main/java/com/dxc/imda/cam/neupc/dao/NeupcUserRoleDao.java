package com.dxc.imda.cam.neupc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.imda.cam.neupc.entity.UserRole;

@Repository
public interface NeupcUserRoleDao extends JpaRepository<UserRole, Long> {
	
	static final String countQuery = "SELECT count(userRole.roleName) "
		+ "FROM UserRole userRole ";
		//+ "JOIN userRole.userProfiles userProfile ";
	    //+ "JOIN userProfile.codeOrg codeOrg ";
	
	static final String sqlQuery = "SELECT userRole "
		+ "FROM UserRole userRole ";
	
	static final String whereClauseEqRoleName = "WHERE UPPER(userRole.roleName) = UPPER(:roleName) ";	
	static final String whereClauseLikeRoleName = "WHERE userRole.roleName LIKE %:roleName% ";
	
	static final String whereClauseEqRoleDesc = "WHERE userRole.roleDesc = :roleDesc ";
	static final String whereClauseLikeRoleDesc = "WHERE userRole.roleDesc LIKE %:roleDesc% ";	
	
	//static final String whereClauseRoleFilter = "WHERE UPPER(userRole.moduleName) = 'IDAADMIN' ";	
	//static final String andClauseRoleFilter = "AND UPPER(userRole.moduleName) = 'IDAADMIN' ";	
	
	//static final String whereClauseRoleFilter = "WHERE userProfile.org_id <> 700 AND UPPER(codeOrg.orgType) = 'IDA' ";	
	//static final String andClauseRoleFilter = "AND userProfile.org_id <> 700 AND UPPER(codeOrg.orgType) = 'IDA' ";
	
	static final String whereClauseActiveStatus = "WHERE userRole.status = 'A' ";
	static final String andClauseActiveStatus = "AND userRole.status = 'A' ";
	
	// TODO: might change if there's an updateGroup API
	@Query(value=sqlQuery + whereClauseEqRoleName + andClauseActiveStatus)
	public UserRole findByRoleName(String roleName);
	
	/** Count **/

	@Query(value=countQuery + whereClauseActiveStatus)
	public Long countAll();
	
	@Query(value=countQuery + whereClauseEqRoleName + andClauseActiveStatus)	
	public Long countByRoleNameEquals(String roleName);
	
	@Query(value=countQuery + whereClauseLikeRoleName + andClauseActiveStatus)	
	public Long countByRoleNameContaining(String roleName);
	
	@Query(value=countQuery + whereClauseEqRoleDesc + andClauseActiveStatus)	
	public Long countByRoleDescEquals(String roleDesc);
	
	@Query(value=countQuery + whereClauseLikeRoleDesc + andClauseActiveStatus)
	public Long countByRoleDescContaining(String roleDesc);
	
	/** List **/
	
	@Query(value=sqlQuery + whereClauseActiveStatus)
	public Page<UserRole> findAll(Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseEqRoleName + andClauseActiveStatus)	
	public Page<UserRole> findByRoleNameEquals(String roleName, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseLikeRoleName + andClauseActiveStatus)	
	public Page<UserRole> findByRoleNameContaining(String roleName, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseEqRoleDesc + andClauseActiveStatus)	
	public Page<UserRole> findByRoleDescEquals(String roleDesc, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseLikeRoleDesc + andClauseActiveStatus)
	public Page<UserRole> findByRoleDescContaining(String roleDesc, Pageable pageable);		
}
