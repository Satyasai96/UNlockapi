package com.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.UnlockAccRequest;
import com.info.constants.AppConstants;
import com.info.entity.UserEntity;
import com.info.props.AppProperties;
import com.info.repository.UserRepository;
@Service
public class UnlockAccountServiceImpl implements UnlockAccountService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private AppProperties appProps;

	@Override
	public String unlocAccount(UnlockAccRequest request) {
		UserEntity user = repo.findByUserEmailAndUserPwd(request.getEmail(), request.getTempPwd());
		if(user!= null) {
			user.setUserPwd(request.getNewTemp());
			user.setUserAccountStatus(AppConstants.UNLOCKED);
			repo.save(user);
			return appProps.getMessages().get(AppConstants.ACC_UNLOCK_SUCCESS);
		}
		return appProps.getMessages().get(AppConstants.INVALID_TEMP_PWD);
	}

}
