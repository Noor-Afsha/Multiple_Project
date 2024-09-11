package com.Wecoodee.cCustomerAppliaction.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoading {

	public LazyLoading() {
		System.out.println("lazy loading bean is executed");
	}
}
