package com.boventech.cms.service.impl;

import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService{

	private static final String COMMA = ",";

	private static final String UTF_8 = "UTF-8";

	private JavaMailSender javaMailSender;
	
	private String from;
	
	private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	public void sendEmail(String to, String subject, String content) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,
				UTF_8);
		try {
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			this.javaMailSender.send(message);
		} catch (MessagingException e) {
			LOG.info(e.getMessage());
		}
	}

	public void sendEmail(List<String> toList, String subject, String content) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,
				UTF_8);
		String tos = getMailList(toList);
		try {
			InternetAddress[] addresses = InternetAddress.parse(tos);
			message.setRecipients(Message.RecipientType.TO, addresses);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(content, true);
			this.javaMailSender.send(message);
		} catch (MessagingException e) {
			LOG.info(e.getMessage());
		}
	}

	private String getMailList(List<String> toList) {
		StringBuffer buffer = new StringBuffer();
		for(String to:toList){
			if(to != null){
				if(buffer.length() > 0)
					buffer.append(COMMA);
				buffer.append(to);
			}
		}
		return buffer.toString();
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setFrom(String from) {
		this.from = from;
	}


}
