package com.example.demo.studentDto;

public class ResetPasswordDto {
	private String emailId;
	private String oldPassword;
	private String newPassword;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ResetPassword [emailId=" + emailId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ "]";
	}

}
