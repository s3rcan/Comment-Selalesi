package com.commentselalesi.ws.user.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateVM {
	
	@NotNull
	 @Size(min= 4, max=255 )
	private String displayName;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
