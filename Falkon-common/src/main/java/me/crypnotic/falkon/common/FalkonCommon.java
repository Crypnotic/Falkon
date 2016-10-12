package me.crypnotic.falkon.common;

import lombok.Getter;
import me.crypnotic.falkon.common.objects.constants.Outcome;
import me.crypnotic.falkon.common.objects.platformers.IPlatform;

public class FalkonCommon {

	@Getter(lombok.AccessLevel.PUBLIC)
	private final IPlatform platform;

	public FalkonCommon(IPlatform platform) {
		this.platform = platform;
	}

	public Outcome enable() {

		return Outcome.SUCCESSFUL;
	}

	public Outcome disable() {

		return Outcome.SUCCESSFUL;
	}
}
