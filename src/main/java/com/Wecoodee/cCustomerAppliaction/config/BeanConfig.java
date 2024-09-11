package com.Wecoodee.cCustomerAppliaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Wecoodee.cCustomerAppliaction.bean.TestBean;

@Configuration
public class BeanConfig {

	@Bean
	public TestBean testBean() {
		return new TestBean();
	}
}
