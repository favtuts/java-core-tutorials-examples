package com.favtuts.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloEhCache{
	
	private final static Logger logger = LoggerFactory.getLogger(HelloEhCache.class);
	
	public static void main(String[] args) {
		
		logger.debug("Starting Ehcache...");
		
		CacheManager cm = CacheManager.getInstance();
		cm.addCache("cache1");
		Cache cache = cm.getCache("cache1");
		
		cache.put(new Element("1","Jan"));
		cache.put(new Element("2","Feb"));
		cache.put(new Element("3","Mar"));
		
		logger.debug("cache : {}", cache);
		
		Element ele = cache.get("2");
		
		String output = (ele == null ? null : ele.getObjectValue().toString());
		System.out.println(output);
		
		logger.debug("element : {}", ele);
		
		cm.shutdown();
		logger.debug("Shutting down Ehcache...");
	}
	
}