package com.ncscode.library_api.entities.enums;

public enum LoanStatus {
	
	OPEN(1),
	RETURNED(2),
	LATE(3);
	
	private Integer code;
	
	private LoanStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
