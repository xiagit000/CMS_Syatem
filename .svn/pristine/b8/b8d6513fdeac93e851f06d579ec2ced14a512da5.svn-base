package com.boventech.sr4j;

import java.util.regex.Pattern;

public class URLRewriteRule {
	
	private final String from;
	private final String to;

	public URLRewriteRule(String from, String to) {
		if(isEmptyString(from) || isEmptyString(to)){
			throw new IllegalArgumentException("neither the from string nor the to string in the rule can be empty");
		}
		this.from = from;
		this.to = to;
	}
	
	private boolean isEmptyString(String str) {
		return str == null || "".equals(str.trim());
	}

	
	public Matcher match(String toRewrite) {
		Matcher matcher; 
		Pattern p = Pattern.compile(from);
		java.util.regex.Matcher m = p.matcher(toRewrite);
		if(m.matches()) {
			int count = m.groupCount();
			String toPattern = to;
			for(int i=1; i<= count; i++) {
				toPattern = toPattern.replace("$"+i, m.group(i));
			}
			matcher = new MatcherImpl(toRewrite, toPattern, true);
			
		} else {
			matcher = new MatcherImpl(toRewrite, toRewrite, false) ;
		}
		
		return matcher;
	}
	
	
	public String from() {
		return from;
	}
	
	public String to() {
		return to;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof URLRewriteRule){
			URLRewriteRule rule = (URLRewriteRule)obj;
			return this.from.equals(rule.from);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.from.hashCode();
	}
	
}


class MatcherImpl implements Matcher{
	
	private final String to;
	private final String from;
	private boolean matched;

	public MatcherImpl(String from, String to, boolean matched) {
		this.from = from;
		this.to = to;
		this.matched = matched;
	}
	
	public String orignalURL() {
		return this.from;
	}
	
	
	public String getMatchedURL() {
		return this.to;
	}
	
	public boolean isMatch() {
		return this.matched;
	}
	
	
}
