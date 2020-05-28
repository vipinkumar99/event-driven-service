package org.order.cloud.enums;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderType {
	PURCHASE("PURCHASE"), 
	RETURN("RETURN"), 
	EXCHANGE("EXCHANGE"), 
	@JsonEnumDefaultValue
	NONE("NONE");

	@Getter
	@JsonValue
	private String value;

	public static final String COL_DEF = "ENUM('PURCHASE','RETURN','EXCHANGE','NONE') DEFAULT 'NONE'";
}
