package com.dxc.imda.cam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dxc.imda.cam.common.model.GroupInfo;
import com.dxc.imda.cam.common.model.UpdateInfo;
import com.dxc.imda.cam.common.model.UserInfo;
import com.dxc.imda.cam.neupc.service.NeupcUserProfileService;
import com.dxc.imda.cam.neupc.service.NeupcUserRoleService;

@SpringBootApplication
@Component
@EnableTransactionManagement
public class NeupcCamApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	private static Logger logger = LoggerFactory.getLogger(NeupcCamApplication.class);
	
	@Autowired
	NeupcUserProfileService neupcUserProfileService;
	
	@Autowired
	NeupcUserRoleService neupcUserRoleService;

	public static void main(String[] args) {
		logger.info("********** STARTING THE APPLICATION ********** ");
		SpringApplication.run(NeupcCamApplication.class, args);
		logger.info("********** APPLICATION END ********** ");
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NeupcCamApplication.class);
    }

	@Override
	public void run(String... args) throws Exception {

		/*
		String userId = "S1159030F";
		String roleName1 = "IMDA_APP_ADMIN";
		String roleName2 = "IMDA";
		
		String roleDesc1 = "IMDA Application Administrator";
		String roleDesc2 = "IMDA";
		String status1 = "A";
		String status2 = "I";
		
		Pageable pageable = PageRequest.of(0, 20);
		Page<UserInfo> userInfos = null;
		Page<GroupInfo> groupInfos = null;
		
		UserInfo userInfo = neupcUserProfileService.findByUserId(userId);
		userInfos = neupcUserProfileService.findAll(pageable);
		userInfos = neupcUserProfileService.findByRoleNameEquals(roleName1, pageable);
		userInfos = neupcUserProfileService.findByRoleNameContaining(roleName2, pageable);
		
		userInfos = neupcUserProfileService.findByRoleDescEquals(roleName1, pageable);
		userInfos = neupcUserProfileService.findByRoleDescContaining(roleName2, pageable);
				
		GroupInfo groupInfo = neupcUserRoleService.findByRoleName(roleName1);
		groupInfos = neupcUserRoleService.findAll(pageable);
		groupInfos = neupcUserRoleService.findByRoleNameEquals(roleName1, pageable);
		groupInfos = neupcUserRoleService.findByRoleNameContaining(roleName2, pageable);
		
		groupInfos = neupcUserRoleService.findByRoleDescEquals(roleDesc1, pageable);
		groupInfos = neupcUserRoleService.findByRoleDescContaining(roleDesc2, pageable);		
		*/
		//userInfo = neupcUserProfileService.updateUser(userId, status1);
		//UpdateInfo updateInfo = neupcUserProfileService.removeUser(userId, status2);
	}
}
