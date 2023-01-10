package com.sangamone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:messages.properties")
public class MessagesForRestApis {

	@Autowired
	Environment environment;
	
	public static final String RESULT_ONE ="RESULT_ONE";
	
	public static final String MESSAGE_ONE ="MESSAGE_ONE";
	
	public String getMessage(String key) {
		return environment.getProperty(key);

	}
	
}
