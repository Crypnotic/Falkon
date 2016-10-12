package me.crypnotic.falkon.common.objects;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FalkonTransaction {

	@Getter(lombok.AccessLevel.PUBLIC)
	private final String identifier; /* Format: uuid-timestamp */
	@Getter(lombok.AccessLevel.PUBLIC)
	private final UUID receiver;
	@Getter(lombok.AccessLevel.PUBLIC)
	private final UUID sender;
	@Getter(lombok.AccessLevel.PUBLIC)
	private final Long timestamp;
}
