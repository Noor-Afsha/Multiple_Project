package com.Wecoodee.cCustomerAppliaction.lazy;

import org.springframework.stereotype.Component;

@Component

public class EagerLoading {
	public EagerLoading() {
		System.out.println("eager loading is executed");
	}
}
