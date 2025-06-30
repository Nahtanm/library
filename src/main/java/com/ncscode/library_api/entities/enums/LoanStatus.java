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
	
	public static LoanStatus valueOf(Integer code) {
		for(LoanStatus x : LoanStatus.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Code invalid");
	}
	
}
