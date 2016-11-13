package me.crypnotic.falkon.bukkit;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.crypnotic.falkon.common.FalkonCommon;
import me.crypnotic.falkon.common.objects.FalkonTransaction;
import me.crypnotic.falkon.common.objects.FalkonTransactionResult;
import me.crypnotic.falkon.common.objects.platformers.IPlatform;

public class FalkonBukkit extends JavaPlugin implements IPlatform {

	@Getter(lombok.AccessLevel.PUBLIC)
	private FalkonCommon common;

	@Override
	public void onEnable() {
		common = new FalkonCommon(this);
	}

	@Override
	public void onDisable() {

	}

	@Override
	public void log(Level level, String message) {
		getLogger().log(level, message);
	}

	@Override
	public FalkonTransactionResult transact(FalkonTransaction transaction) {
		return null;
	}
}
