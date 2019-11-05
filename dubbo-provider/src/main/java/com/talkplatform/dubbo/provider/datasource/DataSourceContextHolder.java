package com.talkplatform.dubbo.provider.datasource;

public class DataSourceContextHolder {

	private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

	public static void set(String dbKey) {
		CONTEXT.set(dbKey);
	}

	public static String get() {
		return CONTEXT.get();
	}

	public static void remove() {
		CONTEXT.remove();
	}

}
