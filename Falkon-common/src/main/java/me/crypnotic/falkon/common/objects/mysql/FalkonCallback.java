package me.crypnotic.falkon.common.objects.mysql;

@FunctionalInterface
public interface FalkonCallback<T> {

	void call(T object);
}
