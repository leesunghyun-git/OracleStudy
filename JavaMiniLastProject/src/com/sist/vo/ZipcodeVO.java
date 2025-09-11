package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

public class ZipcodeVO {
	@Getter
	@Setter
	private String zipcode, sido,gugun,dong,bunji;
	private String address;
	public String getAddress() {
		return sido+" "+gugun+" "+dong+" "+bunji;
	}
	
}
