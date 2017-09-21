package com.realgnu.mySpring.authorities.controller;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthoritiesController {
	private static Logger logger = Logger.getLogger(AuthoritiesController.class);
	@Autowired
	private CacheManager cacheManager;
	@RequestMapping("/authorities/authority1.do")
	public String authority1() {
		return "tiles.authority1";
	}
	@RequestMapping("/authorities/authority2.do")
	public String authority2() {
		return "tiles.authority2";
	}
	@RequestMapping("/authorities/authority3.do")
	public String authority3() {
		return "tiles.authority3";
	}
	@RequestMapping("/authorities/clearCache.do")
	public String clearCache() {
		Iterator itr = cacheManager.getCacheNames().iterator();
		while (itr.hasNext()) {
			String cacheName = itr.next().toString();
			logger.debug("Cache clear >> cache name : " + cacheName);
			cacheManager.getCache(cacheName).clear();
		}
		return "redirect:/member/login.do";
	}
	
}
