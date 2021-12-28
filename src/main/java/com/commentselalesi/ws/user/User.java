package com.commentselalesi.ws.user;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;




@Entity
public class User implements UserDetails{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1740801933889958154L;

	 @Id
	 @GeneratedValue
	 private long id;
	 
	 @NotNull
	 @Size(min= 4, max=255 )
	 @UniqueUsername
	 private String username;
	 
	 @NotNull
	 @Size(min= 4, max=255 )
	 private String displayName;
	 
	 @NotNull
	 @Size(min= 8, max=255 )
	 @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="A-a, min 8 , max 255 character ")  //*$")
	 private String password;
	 
	 @Lob
	 @Basic(fetch=FetchType.LAZY)
	 @Column(name = "BlobField", columnDefinition = "LONGBLOB")
	 private String image;
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", displayName=" + displayName + ", password=" + password +"]";
	}


	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("Role_user");
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
}
