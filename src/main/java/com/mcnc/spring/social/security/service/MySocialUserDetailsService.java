package com.mcnc.spring.social.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import com.mcnc.spring.social.security.dao.MyUserAccountDAO;
import com.mcnc.spring.social.security.model.MyUserAccount;
import com.mcnc.spring.social.security.user.MySocialUserDetails;

@Service
public class MySocialUserDetailsService implements SocialUserDetailsService {

	@Autowired
	private MyUserAccountDAO myUserAccountDAO;

	// Loads the UserDetails by using the userID of the user.
	// (This method is used by Spring Security API).
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {

		MyUserAccount account = myUserAccountDAO.findById(userId);

		MySocialUserDetails userDetails = new MySocialUserDetails(account);

		return userDetails;
	}

}
