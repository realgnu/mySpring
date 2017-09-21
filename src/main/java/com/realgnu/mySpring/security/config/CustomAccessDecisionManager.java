package com.realgnu.mySpring.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

public class CustomAccessDecisionManager extends AbstractAccessDecisionManager{

	private static Logger logger = Logger.getLogger(CustomAccessDecisionManager.class);
	
	protected CustomAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		int grant = 0;
		int abstain = 0;

		List<ConfigAttribute> singleAttributeList = new ArrayList<ConfigAttribute>(1);
		singleAttributeList.add(null);

		for (ConfigAttribute attribute : configAttributes) {
			singleAttributeList.set(0, attribute);

			for (AccessDecisionVoter voter : getDecisionVoters()) {
				int result = voter.vote(authentication, object, singleAttributeList);

				logger.debug("Voter: " + voter + ", returned: " + result);

				switch (result) {
				case AccessDecisionVoter.ACCESS_GRANTED:
					grant++;

					break;

				case AccessDecisionVoter.ACCESS_DENIED:
					throw new AccessDeniedException(SecurityConst.ACCESS_DENIED);

				default:
					abstain++;
					break;
				}
			}
		}

		if (grant > 0 && abstain == 0) {
			return;
		} else {
			throw new AccessDeniedException(SecurityConst.ACCESS_DENIED);
		}
		
	}

}
