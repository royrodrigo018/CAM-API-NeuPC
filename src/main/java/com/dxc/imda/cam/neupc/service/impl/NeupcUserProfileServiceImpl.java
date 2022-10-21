package com.dxc.imda.cam.neupc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dxc.imda.cam.common.constant.Constants;
import com.dxc.imda.cam.common.model.UpdateInfo;
import com.dxc.imda.cam.common.model.UserInfo;
import com.dxc.imda.cam.neupc.dao.NeupcUserProfileDao;
import com.dxc.imda.cam.neupc.entity.UserProfile;
import com.dxc.imda.cam.neupc.mapper.NeupcUserInfoMapper;
import com.dxc.imda.cam.neupc.service.NeupcUserProfileService;

@Service
public class NeupcUserProfileServiceImpl implements NeupcUserProfileService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NeupcUserProfileDao neupcUserProfileDao;
	
	@Autowired
	private NeupcUserInfoMapper neupcUserInfoMapper;
	
	@Override
	public Long countAll() {
		return neupcUserProfileDao.countAll();
	}

	@Override
	public Long countByRoleNameEquals(String roleName) {
		return neupcUserProfileDao.countByRoleNameEquals(roleName);
	}

	@Override
	public Long countByRoleNameContaining(String roleName) {
		return neupcUserProfileDao.countByRoleNameContaining(roleName);
	}

	@Override
	public Long countByRoleDescEquals(String roleDesc) {
		return neupcUserProfileDao.countByRoleDescEquals(roleDesc);
	}

	@Override
	public Long countByRoleDescContaining(String roleDesc) {
		return neupcUserProfileDao.countByRoleDescContaining(roleDesc);
	}

	@Override
	public UserInfo findByUserId(String userId) {
		UserInfo userInfo = new UserInfo();
		try {
			UserProfile userProfile = neupcUserProfileDao.findByUserId(userId);
			if (userProfile != null) {
				userInfo = getUserInfo(userProfile);
			}
		}catch(Exception e) {
			e.printStackTrace();
			userInfo = null;
		}
		return userInfo;
	}	

	@Override
	public Page<UserInfo> findAll(Pageable pageable){
		List<UserInfo> userInfos = new ArrayList<>();
		try {
			Page<UserProfile> pagedUserProfiles = neupcUserProfileDao.findAll(pageable);
			logger.info("findAll pagedUserProfiles: " + pagedUserProfiles);
			List<UserProfile> userProfiles = pagedUserProfiles.getContent();
			logger.info("findAll userProfiles.size(): " + userProfiles.size());
			userInfos = getUserInfos(userProfiles);
			logger.info("findAll userInfos.size(): " + userInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			userInfos = null;
		}
		return new PageImpl<UserInfo>(userInfos, pageable, userInfos.size());
	}

	@Override
	public Page<UserInfo> findByRoleNameEquals(String roleName, Pageable pageable){
		List<UserInfo> userInfos = new ArrayList<>();
		try {
			Page<UserProfile> pagedUserProfiles = neupcUserProfileDao.findByRoleNameEquals(roleName, pageable);
			logger.info("findByRoleNameEquals pagedUserProfiles: " + pagedUserProfiles);
			List<UserProfile> userProfiles = pagedUserProfiles.getContent();
			logger.info("findByRoleNameEquals userProfiles.size(): " + userProfiles.size());
			userInfos = getUserInfos(userProfiles);
			logger.info("findByRoleNameEquals userInfos.size(): " + userInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			userInfos = null;
		}
		return new PageImpl<UserInfo>(userInfos, pageable, userInfos.size());
	}

	@Override
	public Page<UserInfo> findByRoleNameContaining(String roleName, Pageable pageable){
		List<UserInfo> userInfos = new ArrayList<>();
		try {
			Page<UserProfile> pagedUserProfiles = neupcUserProfileDao.findByRoleNameContaining(roleName, pageable);
			logger.info("findByRoleNameContaining pagedUserProfiles: " + pagedUserProfiles);
			List<UserProfile> userProfiles = pagedUserProfiles.getContent();
			logger.info("findByRoleNameContaining userProfiles.size(): " + userProfiles.size());
			userInfos = getUserInfos(userProfiles);
			logger.info("findByRoleNameContaining userInfos.size(): " + userInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			userInfos = null;
		}
		return new PageImpl<UserInfo>(userInfos, pageable, userInfos.size());
	}

	@Override
	public Page<UserInfo> findByRoleDescEquals(String roleDesc, Pageable pageable){
		List<UserInfo> userInfos = new ArrayList<>();
		try{
			Page<UserProfile> pagedUserProfiles = neupcUserProfileDao.findByRoleDescEquals(roleDesc, pageable);
			logger.info("findByRoleDescEquals pagedUserProfiles: " + pagedUserProfiles);
			List<UserProfile> userProfiles = pagedUserProfiles.getContent();
			logger.info("findByRoleDescEquals userProfiles.size(): " + roleDesc +" = "+ userProfiles.size());
			userInfos = getUserInfos(userProfiles);
			logger.info("findByRoleDescEquals userInfos.size(): " + userInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			userInfos = null;
		}
		return new PageImpl<UserInfo>(userInfos, pageable, userInfos.size());
	}

	@Override
	public Page<UserInfo> findByRoleDescContaining(String roleDesc, Pageable pageable){
		List<UserInfo> userInfos = new ArrayList<>();
		try {
			Page<UserProfile> pagedUserProfiles = neupcUserProfileDao.findByRoleDescContaining(roleDesc, pageable);
			logger.info("findByRoleDescContaining pagedUserProfiles: " + pagedUserProfiles);
			List<UserProfile> userProfiles = pagedUserProfiles.getContent();			
			logger.info("findByRoleDescContaining userProfiles.size(): " + roleDesc +" = "+ userProfiles.size());
			userInfos = getUserInfos(userProfiles);
			logger.info("findByRoleDescContaining userInfos.size(): " + userInfos.size());
		}catch(Exception e) {
			e.printStackTrace();
			userInfos = null;
		}
		return new PageImpl<UserInfo>(userInfos, pageable, userInfos.size());
	}	
	
	@Override
	public UserInfo updateUser(String userId, String status) {
		UserInfo userInfo = new UserInfo();
		try {	
			UserProfile userProfileExist = neupcUserProfileDao.findByUserId(userId);
			logger.info("updateUser userProfileExist.getId(): " + userProfileExist.getId());
			UserProfile userProfile = setUserProfile(userProfileExist, userId, status);
			userProfile = neupcUserProfileDao.save(userProfile);
			logger.info("updateUser userId: " + userId);
			logger.info("updateUser status: " + userProfileExist.getStatus());
			logger.info("updateUser status: " + userProfile.getStatus());
			userInfo = getUserInfo(userProfile);								
		}catch(Exception e) {
			e.printStackTrace();
			userInfo = null;
		}
		return userInfo;
	}
	
	@Override
	public UserInfo updateUser(String userId, Boolean blnValue) {
		UserInfo userInfo = new UserInfo();
		try {	
			UserProfile userProfileExist = neupcUserProfileDao.findByUserId(userId);
			logger.info("updateUser userProfileExist.getId(): " + userProfileExist.getId());
			UserProfile userProfile = setUserProfile(userProfileExist, userId, blnValue);
			userProfile = neupcUserProfileDao.save(userProfile);
			logger.info("updateUser userId: " + userId);
			logger.info("updateUser status: " + userProfileExist.getStatus());
			logger.info("updateUser status: " + userProfile.getStatus());
			userInfo = getUserInfo(userProfile);								
		}catch(Exception e) {
			e.printStackTrace();
			userInfo = null;
		}
		return userInfo;
	}

	@Override
	public UpdateInfo removeUser(String userId, String status) {
		UpdateInfo updateInfo = new UpdateInfo();
		try {	
			UserProfile userProfileExist = neupcUserProfileDao.findByUserId(userId);
			UserProfile userProfile = setUserProfile(userProfileExist, userId, status);
			userProfile = neupcUserProfileDao.save(userProfile);			
			updateInfo = getUpdateInfo(userProfile);
			logger.info("removeUser userId: " + userId);
			logger.info("removeUser status: " + userProfileExist.getStatus());
			logger.info("removeUser status: " + userProfile.getStatus());
			logger.info("remove updateInfo: " + updateInfo);
		}catch(Exception e) {
			e.printStackTrace();
			updateInfo = null;
		}
		return updateInfo;
	}
	
	/** private methods **/
	
	private List<UserInfo> getUserInfos(List<UserProfile> userProfiles){
		List<UserInfo> userInfos = new ArrayList<>();
		for (UserProfile userProfile: userProfiles) {
			UserInfo userInfo = getUserInfo(userProfile);
			userInfos.add(userInfo);
		}
		return userInfos;
	}
	
	private UserInfo getUserInfo(UserProfile userProfile){
		return neupcUserInfoMapper.convertUserToJSON(userProfile);		
	}
	
	private UpdateInfo getUpdateInfo(UserProfile userProfile){
		return neupcUserInfoMapper.convertUpdateInfoToJSON(userProfile);		
	}
	
	private UserProfile setUserProfile(UserProfile userProfileExist, String userId, String status) {
		UserProfile userProfile = new UserProfile(userProfileExist);
		userProfile.setUserId(userId);
		userProfile.setLastUpdBy(Constants.CAM_USER);
		userProfile.setLastUpdDate(new Date());
		userProfile.setStatus(status);	
		userProfile.setStatusDate(new Date());
		return userProfile;		
	}	
	
	private UserProfile setUserProfile(UserProfile userProfileExist, String userId, Boolean blnValue) {
		UserProfile userProfile = new UserProfile(userProfileExist);
		userProfile.setUserId(userId);
		userProfile.setLastUpdBy(Constants.CAM_USER);
		userProfile.setLastUpdDate(new Date());
		String status = userProfile.getStatus();
		if (blnValue) {
			if (userProfile.getStatus().equalsIgnoreCase(Constants.INACTIVE_STATUS)) {
				status = Constants.ACTIVE_STATUS;
			}else {
				status = Constants.INACTIVE_STATUS;
			}
		}	
		userProfile.setStatus(status);
		userProfile.setStatusDate(new Date());
		return userProfile;		
	}
}
