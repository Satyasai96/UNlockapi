package com.info.binding;

import lombok.Data;

@Data
public class UnlockAccRequest {
	private String email;
	private String tempPwd;
	private String newTemp;
	private String confirmPwd;
	

}
