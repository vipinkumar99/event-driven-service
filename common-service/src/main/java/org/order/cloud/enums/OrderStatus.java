package org.order.cloud.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderStatus {
@JsonEnumDefaultValue
NEW("NEW"),
PROCESSING("PROCESSING"),
DONE("DONE"),
ERROR("ERROR");

	@Getter
	@JsonValue
	private String value;

	public static final String COL_DEF = "ENUM('NEW','PROCESSING','DONE','ERROR') DEFAULT 'NEW'";
}
