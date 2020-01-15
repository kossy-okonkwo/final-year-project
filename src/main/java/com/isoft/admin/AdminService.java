package com.isoft.admin;

import org.springframework.validation.BindingResult;

/**
 * Created by mac on 03/12/2019.
 */
public interface AdminService {
	Admin findAdminById(Long id);
	void createAdmin(NewAdminCmd newAdminCmd);
	void checkUsernameOrEmailExist (NewAdminCmd cmd, BindingResult result);
	boolean isFirstLogin()throws Exception;
}
