package com.boventech.cms.action.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boventech.cms.module.email.EmailTemplate;

/**
 * Util class for load template
 * @author Junxue Rao
 *
 */
public final class TemplateUtil {
	
	private static final String BARCE_POSTFIX = "\\}";

	private static final String BRACE_PREFIX = "\\{";

	private static final String TITLE_POSTFIX = "</title>";

	private static final String TITLE_PREFIX = "<title>";

	private static final Logger LOG = LoggerFactory.getLogger(TemplateUtil.class);

	private static final String UTF_8 = "UTF-8";

	private static final int ONE_K = 1024;
	
	
	static{
		TemplateUtil.class.getClassLoader().getResource("");
	}
	
	private TemplateUtil(){

	}
	
	public static EmailTemplate newTemplate(File templateFile, String[] titleReplaces, String[] contentReplaces){
		EmailTemplate template = new EmailTemplate();
		template.setSubject(getText(readTitle(templateFile), titleReplaces));
		template.setContent(getText(readHTML(templateFile), contentReplaces));
		return template;
	}
	
	private static String getText(String text, String[] replaces){
		if(text != null){
			String content = text;
			for(int i=0;i<replaces.length;i++){
				content = content.replaceAll(BRACE_PREFIX+i+BARCE_POSTFIX, replaces[i]);
			}
			return content;
		}
		return null;
	}

	public static String getSubject(File template){
		return readTitle(template);
	}
	

	public static String getTemplate(File template){
		return readHTML(template);
	}
	
	private static String readHTML(File template){
		String content = null;
		if(template.exists() && template.isFile()){
			FileInputStream inputStream = null;
			try {
				byte[] bigBuffer = new byte[ONE_K * ONE_K];
				byte[] buffer = new byte[ONE_K];
				int size = 0;
				int length = 0;
				inputStream = new FileInputStream(template);
				while((size = inputStream.read(buffer)) != -1){
					System.arraycopy(buffer, 0, bigBuffer, length, size);
					length += size;
				}
				byte[] finalBuffer = Arrays.copyOf(bigBuffer, length);
				content = new String(finalBuffer, UTF_8);
			} catch (FileNotFoundException e) {
				LOG.info(e.getMessage());
			} catch (IOException e) {
				LOG.info(e.getMessage());
			}finally{
				closeStream(inputStream);
			}
		}
		return content;
	}

	private static void closeStream(FileInputStream inputStream) {
		if(inputStream != null){
			try {
				inputStream.close();
			} catch (IOException e) {
				LOG.info(e.getMessage());
			}
		}
	}

	private static String readTitle(File template) {
		String content = readHTML(template);
		int start = content.indexOf(TITLE_PREFIX) + TITLE_PREFIX.length();
		int end = content.lastIndexOf(TITLE_POSTFIX);
		if(start - TITLE_PREFIX.length() != -1 && end > start){
			return content.substring(start, end);
		}
		return null;
	}
}
