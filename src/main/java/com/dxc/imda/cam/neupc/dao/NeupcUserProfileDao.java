package com.dxc.imda.cam.neupc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.imda.cam.neupc.entity.UserProfile;

@Repository
public interface NeupcUserProfileDao extends JpaRepository<UserProfile, Long> {
	
	static final String countQuery = "SELECT count(userProfile.userId) "
		+ "FROM UserProfile userProfile "
		+ "JOIN userProfile.userRole userRole "
		+ "JOIN userProfile.codeOrg codeOrg ";
	
	static final String sqlQuery = "SELECT userProfile "
		+ "FROM UserProfile userProfile "
		+ "JOIN userProfile.userRole userRole "
		+ "JOIN userProfile.codeOrg codeOrg ";
	
	static final String whereClauseEqUserId = "WHERE UPPER(userProfile.userId) = UPPER(:userId) ";	
	
	static final String whereClauseEqRoleName = "WHERE UPPER(userRole.roleName) = UPPER(:roleName) ";	
	static final String whereClauseEqRoleDesc = "WHERE userRole.roleDesc = :roleDesc ";

	static final String whereClauseLikeRoleName = "WHERE userRole.roleName LIKE %:roleName% ";	
	static final String whereClauseLikeRoleDesc = "WHERE userRole.roleDesc LIKE %:roleDesc% ";	
	
	//static final String whereClauseRoleFilter = "WHERE UPPER(userRole.moduleName) = 'IDAADMIN' OR UPPER(userRole.moduleName) = 'IDASYSTEM' ";	
	//static final String andClauseRoleFilter = "AND UPPER(userRole.moduleName) = 'IDAADMIN' OR UPPER(userRole.moduleName) = 'IDASYSTEM' ";	
	
//	static final String whereClauseRoleFilter = "WHERE userProfile.orgId <> 700 AND UPPER(codeOrg.orgType) = 'IDA' ";	
//	static final String andClauseRoleFilter = "AND userProfile.orgId <> 700 AND UPPER(codeOrg.orgType) = 'IDA' ";
	
	static final String whereClauseActiveStatus = "WHERE userProfile.status = 'A' ";
	static final String andClauseActiveStatus = "AND userProfile.status = 'A' ";
	
	// TODO: getting exception when filtered with userProfile.status = 'A'
	//@Query(value=sqlQuery + whereClauseEqUserId + andClauseActiveStatus) 
	@Query(value=sqlQuery + whereClauseEqUserId) 
	public UserProfile findByUserId(String userId);
	
	//check user profile status if there's discrepancy in the number of records
	@Query(value=sqlQuery + whereClauseEqRoleName + andClauseActiveStatus)		
	public List<UserProfile> findByRoleName(String roleName);
	
	@Query(value=sqlQuery + whereClauseActiveStatus)
	public List<UserProfile> loadAllUserProfiles();
	
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
	public Page<UserProfile> findAll(Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseEqRoleName + andClauseActiveStatus)	
	public Page<UserProfile> findByRoleNameEquals(String roleName, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseLikeRoleName + andClauseActiveStatus)
	public Page<UserProfile> findByRoleNameContaining(String roleName, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseEqRoleDesc + andClauseActiveStatus)	
	public Page<UserProfile> findByRoleDescEquals(String roleDesc, Pageable pageable);
	
	@Query(value=sqlQuery + whereClauseLikeRoleDesc + andClauseActiveStatus)	
	public Page<UserProfile> findByRoleDescContaining(String roleDesc, Pageable pageable);	
}
