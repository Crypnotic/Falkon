package me.crypnotic.falkon.common.objects.constants;

public enum Outcome {
	SUCCESSFUL, FAILURE, UNKNOWN;

	public Boolean isSuccessful() {
		return (this == Outcome.SUCCESSFUL);
	}
}
