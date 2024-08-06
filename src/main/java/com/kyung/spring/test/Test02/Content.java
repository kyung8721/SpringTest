package com.kyung.spring.test.Test02;

import java.util.HashMap;
import java.util.Map;

public class Content {
	
	private String title;
	private String user;
	private String content;
	
	public Content(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
