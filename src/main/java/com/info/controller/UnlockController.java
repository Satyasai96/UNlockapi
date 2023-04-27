package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.UnlockAccRequest;
import com.info.service.UnlockAccountServiceImpl;

@RestController
public class UnlockController {
	@Autowired
	private UnlockAccountServiceImpl service;
	@PostMapping("/unlockAccount")
	public String unlockAccount(@RequestBody UnlockAccRequest request) {
		return service.unlocAccount(request);
		
	}

}
