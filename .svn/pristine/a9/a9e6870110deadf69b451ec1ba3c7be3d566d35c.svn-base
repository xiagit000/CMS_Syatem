package com.boventech.sr4j;

import java.util.ArrayList;
import java.util.List;

public class URLRewriteEngine {

	private static final URLRewriteEngine engine = new URLRewriteEngine();

	private List<URLRewriteRule> rules = new ArrayList<URLRewriteRule>();
	
	private URLRewriteEngine() { }
	
	public static URLRewriteEngine getInstance() {
		return engine;
	}

	public void addRule(String from, String to) {
		this.addRule(new URLRewriteRule(from, to));
	}

	public synchronized void addRule(URLRewriteRule rule) {
		if(this.rules.contains(rule)) {
			this.rules.remove(rule);
		}
		this.rules.add(rule);
	}

	public Matcher match(String string) {
		for(URLRewriteRule rule : rules) {
			Matcher matcher = rule.match(string);
			if(matcher.isMatch()) {
				return matcher;
			}
		}
		return new MatcherImpl(string, string, false);
	}

	public synchronized void clearRules() {
		this.rules.clear();
	}

}
