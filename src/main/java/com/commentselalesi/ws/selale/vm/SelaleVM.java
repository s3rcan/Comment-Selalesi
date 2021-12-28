package com.commentselalesi.ws.selale.vm;

import com.commentselalesi.ws.selale.Selale;
import com.commentselalesi.ws.user.vm.UserVM;

public class SelaleVM {

	private long id;
	
	private String content;
	
	private long timeStamp;
	
	private UserVM user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public UserVM getUser() {
		return user;
	}

	public void setUser(UserVM user) {
		this.user = user;
	}
	
	public SelaleVM(Selale selale) {
		this.setId(selale.getId());
		this.setContent(selale.getContent());
		this.setTimeStamp(selale.getTimeStamp().getTime());
		this.setUser(new UserVM(selale.getUser()));
	}	
}
