package me.crypnotic.falkon.common.objects.mysql;

import lombok.Getter;

public class FalkonQuery {

	@Getter(lombok.AccessLevel.PUBLIC)
	private String query;
	@Getter(lombok.AccessLevel.PUBLIC)
	private Object[] values;

	public FalkonQuery(String query, Object... values) {
		this.query = query;
		this.values = values;
	}
}
