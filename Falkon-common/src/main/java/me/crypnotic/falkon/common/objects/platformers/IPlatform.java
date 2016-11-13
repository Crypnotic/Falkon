package me.crypnotic.falkon.common.objects.platformers;

import java.util.logging.Level;

import me.crypnotic.falkon.common.objects.FalkonTransaction;
import me.crypnotic.falkon.common.objects.FalkonTransactionResult;

public interface IPlatform {

	void log(Level level, String message);
	
	FalkonTransactionResult transact(FalkonTransaction transaction);
}
