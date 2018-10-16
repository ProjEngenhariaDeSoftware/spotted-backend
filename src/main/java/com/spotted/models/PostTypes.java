package com.spotted.models;

public enum PostTypes {
	NOTICE("NOTICE"), NEWS("NEWS"), ENTERTAINMENT("ENTERTAINMENT"), EVENT_ACADEMIC("EVENT_ACADEMIC");
	
	private String value;
	
	/**
	 * 
	 * @param value the value represent the type of post.
	 */
	PostTypes(String value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @return The string represent the type of post.
	 */
	public String getValue() {
		return this.value;
	}

}
