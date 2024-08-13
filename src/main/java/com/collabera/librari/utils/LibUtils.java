/**
 * 
 */
package com.collabera.librari.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author User
 *
 */

@Component
@Service
public class LibUtils {
	
	private static Logger logger = LoggerFactory.getLogger(LibUtils.class);
	
    @Autowired
    private Environment env; 
    
	
	public String generateRandom(int start, int end) {

		Random random = new Random();
		logger.debug("Generating Random,,,");
	    return String.valueOf(random.nextInt(end - 
	    		start) + start);
	}
	
	public String generateISBN() {
		
		String strPrefix = env.getProperty("isbn.prefix");
		String strDel = env.getProperty("isbn.del");
		String strSuffix = env.getProperty("isbn.suffix");

		
		return (strPrefix+strDel+generateRandom(2, 9)+
				strDel+generateRandom(5, 16)+strDel+
				generateRandom(101110, 999999)+strDel+
				strSuffix).trim();
		
	}
	
}
