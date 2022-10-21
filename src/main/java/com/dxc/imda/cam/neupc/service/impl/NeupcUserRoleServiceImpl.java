package com.dxc.imda.cam.neupc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dxc.imda.cam.common.model.GroupInfo;
import com.dxc.imda.cam.neupc.dao.NeupcUserProfileDao;
import com.dxc.imda.cam.neupc.dao.NeupcUserRoleDao;
import com.dxc.imda.cam.neupc.entity.UserRole;
import com.dxc.imda.cam.neupc.mapper.NeupcGroupInfoMapper;
import com.dxc.imda.cam.neupc.service.NeupcUserRoleService;
import com.dxc.imda.cam.neupc.entity.UserProfile;

@Service
public class NeupcUserRoleServiceImpl implements NeupcUserRoleService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NeupcUserRoleDao neupcUserRoleDao;
	
	@Autowired
	private NeupcUserProfileDao neupcUserProfileDao;
	
	@Autowired
	private NeupcGroupInfoMapper neupcGroupInfoMapper;
	
	@Override
	public Long countAll() {
		return neupcUserRoleDao.countAll();
	}

	@Override
	public Long countByRoleNameEquals(String roleName) {
		return neupcUserRoleDao.countByRoleNameEquals(roleName);
	}

	@Override
	public Long countByRoleNameContaining(String roleName) {
		return neupcUserRoleDao.countByRoleNameContaining(roleName);
	}

	@Override
	public Long countByRoleDescEquals(String roleDesc) {
		return neupcUserRoleDao.countByRoleDescEquals(roleDesc);
	}

	@Override
	public Long countByRoleDescContaining(String roleDesc) {
		return neupcUserRoleDao.countByRoleDescContaining(roleDesc);
	}

	@Override
	public GroupInfo findByRoleName(String roleName) {
		GroupInfo groupInfo = new GroupInfo();
		try {
			UserRole userRole = neupcUserRoleDao.findByRoleName(roleName);
			logger.info("findByRoleName userRole: " + userRole);
			if (userRole != null) {
				List<UserProfile> userProfiles = getUserProfiles(userRole);	
				logger.info("findByRoleName userProfiles.size(): " + userProfiles.size());
				groupInfo = getGroupInfo(userRole, userProfiles);
			}
		}catch(Exception e) {
			e.printStackTrace();
			groupInfo = null;
		}
		return groupInfo;
	}

	@Override
	public Page<GroupInfo> findAll(Pageable pageable) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			Page<UserRole> pagedUserRoles = neupcUserRoleDao.findAll(pageable);
			logger.info("findAll pagedUserRoles: " + pagedUserRoles);
			List<UserRole> userRoles = pagedUserRoles.getContent();
			logger.info("findAll userRoles.size(): " + userRoles.size());
			groupInfos = getGroupInfos(userRoles);
			logger.info("findAll groupInfos.size(): " + groupInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return new PageImpl<GroupInfo>(groupInfos, pageable, groupInfos.size());
	}

	@Override
	public Page<GroupInfo> findByRoleNameEquals(String roleName, Pageable pageable) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			Page<UserRole> pagedUserRoles = neupcUserRoleDao.findByRoleNameEquals(roleName, pageable);
			logger.info("findByRoleNameEquals pagedUserRoles: " + pagedUserRoles);
			List<UserRole> userRoles = pagedUserRoles.getContent();
			logger.info("findByRoleNameEquals userRoles.size(): " + userRoles.size());
			groupInfos = getGroupInfos(userRoles);
			logger.info("findByRoleNameEquals groupInfos.size(): " + groupInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return new PageImpl<GroupInfo>(groupInfos, pageable, groupInfos.size());
	}

	@Override
	public Page<GroupInfo> findByRoleNameContaining(String roleName, Pageable pageable) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			Page<UserRole> pagedUserRoles = neupcUserRoleDao.findByRoleNameContaining(roleName, pageable);
			logger.info("findByRoleNameContaining pagedUserRoles: " + pagedUserRoles);
			List<UserRole> userRoles = pagedUserRoles.getContent();
			logger.info("findByRoleNameContaining userRoles.size(): " + userRoles.size());
			groupInfos = getGroupInfos(userRoles);
			logger.info("findByRoleNameContaining groupInfos.size(): " + groupInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return new PageImpl<GroupInfo>(groupInfos, pageable, groupInfos.size());
	}

	@Override
	public Page<GroupInfo> findByRoleDescEquals(String roleDesc, Pageable pageable) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			Page<UserRole> pagedUserRoles = neupcUserRoleDao.findByRoleDescEquals(roleDesc, pageable);
			logger.info("findByRoleDescEquals pagedUserRoles: " + pagedUserRoles);
			List<UserRole> userRoles = pagedUserRoles.getContent();
			logger.info("findByRoleDescEquals userRoles.size(): " + userRoles.size());
			groupInfos = getGroupInfos(userRoles);
			logger.info("findByRoleDescEquals groupInfos.size(): " + groupInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return new PageImpl<GroupInfo>(groupInfos, pageable, groupInfos.size());
	}

	@Override
	public Page<GroupInfo> findByRoleDescContaining(String roleDesc, Pageable pageable) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			Page<UserRole> pagedUserRoles = neupcUserRoleDao.findByRoleDescContaining(roleDesc, pageable);
			logger.info("findByRoleDescContaining pagedUserRoles: " + pagedUserRoles);
			List<UserRole> userRoles = pagedUserRoles.getContent();
			logger.info("findByRoleDescContaining userRoles.size(): " + userRoles.size());
			groupInfos = getGroupInfos(userRoles);
			logger.info("findByRoleDescContaining groupInfos.size(): " + groupInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return new PageImpl<GroupInfo>(groupInfos, pageable, groupInfos.size());
	}
	
	private List<GroupInfo> getGroupInfos(List<UserRole> userRoles) {
		List<GroupInfo> groupInfos = new ArrayList<>();
		try {
			List<UserProfile> allUserProfiles = neupcUserProfileDao.loadAllUserProfiles();
			for(UserRole userRole: userRoles) {		
				//List<UserProfile> userProfiles = getUserProfiles(userRole); // TODO
				List<UserProfile> userProfiles = getUserProfiles(allUserProfiles, userRole);
				GroupInfo groupInfo = getGroupInfo(userRole, userProfiles);
				groupInfos.add(groupInfo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			groupInfos = null;
		}
		return groupInfos;
	}	
	
	private List<UserProfile> getUserProfiles(List<UserProfile> allUserProfiles, UserRole userRole){
		List<UserProfile> userProfiles = new ArrayList<>();
		Map<Long, UserProfile> userProfileHashMap = new HashMap<>();
		for (UserProfile tempUserProfile: allUserProfiles) {
			if (userRole.getId().equals(tempUserProfile.getUserRole().getId())) {
				userProfileHashMap.put(userRole.getId(), tempUserProfile);
				userProfiles.add(userProfileHashMap.get(tempUserProfile.getUserRole().getId()));
            }
		}
		return userProfiles;
	}
	
	private GroupInfo getGroupInfo(UserRole userRole, List<UserProfile> userProfiles){
		return neupcGroupInfoMapper.convertUserRoleToJSON(userRole, userProfiles);	
	}
	
	private List<UserProfile> getUserProfiles(UserRole userRole){
		List<UserProfile> userProfiles = new ArrayList<>();	
		try {
			userProfiles = neupcUserProfileDao.findByRoleName(userRole.getRoleName());	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userProfiles;
	}
}
