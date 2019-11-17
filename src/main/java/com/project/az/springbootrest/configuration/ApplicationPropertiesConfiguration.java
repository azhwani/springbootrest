package com.project.az.springbootrest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gapp-config")
@RefreshScope
public class ApplicationPropertiesConfiguration {
	
	private int maxemployees;

	public int getMaxemployees() {
		return maxemployees;
	}

	public void setMaxemployees(int maxemployees) {
		this.maxemployees = maxemployees;
	}

	
	

}
