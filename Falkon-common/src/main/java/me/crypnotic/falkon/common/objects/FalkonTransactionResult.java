package me.crypnotic.falkon.common.objects;

public enum FalkonTransactionResult {
	APPROVED, DENIED;

	public Boolean isApproved() {
		return (this == FalkonTransactionResult.APPROVED);
	}
}
