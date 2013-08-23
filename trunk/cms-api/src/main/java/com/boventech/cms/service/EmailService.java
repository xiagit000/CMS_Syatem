package com.boventech.cms.service;

import java.util.List;

public interface EmailService {

	void sendEmail(String to, String subject, String content);
	
	void sendEmail(List<String> tos, String subject, String content);
}
