package com.project.sparktea.pictureupload;

import java.util.Objects;
import java.util.UUID;

public class ProfileUpload {
	
	private UUID userProfileID;
	private String username;
	private String profileImgLink; // S3 key/link
	
	public ProfileUpload(UUID userProfileID, String username, String profileImgLink) {
		super();
		this.userProfileID = userProfileID;
		this.username = username;
		this.profileImgLink = profileImgLink;
	}

	public UUID getUserProfileID() {
		return userProfileID;
	}

	public void setUserProfileID(UUID userProfileID) {
		this.userProfileID = userProfileID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfileImgLink() {
		return profileImgLink;
	}

	public void setProfileImgLink(String profileImgLink) {
		this.profileImgLink = profileImgLink;
	}

	@Override
	public int hashCode() {
		return Objects.hash(profileImgLink, userProfileID, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ProfileUpload other = (ProfileUpload) obj;
		return Objects.equals(profileImgLink, other.profileImgLink) && 
			   Objects.equals(userProfileID, other.userProfileID) && 
			   Objects.equals(username, other.username);
	}
	
	
	
}
