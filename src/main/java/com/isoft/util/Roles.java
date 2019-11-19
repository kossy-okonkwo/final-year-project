package com.isoft.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 12/11/2019.
 */
public enum Roles {
	STUDENT,
	ADMIN,
	LECTURER;
	
	public static List<Roles> getRole(){
		return Arrays.asList (  Roles.values () );
	}
}
