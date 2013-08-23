package com.boventech.cms.permalink;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.boventech.cms.module.node.Entry;
import com.boventech.permalink.PermalinkVariable;
public enum NewsPermalinkVariable implements PermalinkVariable<Entry>{
	
	
	ENTRY_ID("%{news_id}"){
		@Override
		public String pattern() {
			return "(\\d+)";
		}
		
		
		public String encode(Entry obj) {
			Entry entry = (Entry)obj;
			return entry.getId().toString();
		}
		
	},
	
	ENTRY_YEAR("%{news_year}"){
		@Override
		public String pattern() {
			return "\\d{4}";
		}

		@Override
		public String encode(Entry obj) {
			return getDateString("yyyy", ((Entry)obj).getPublishedDate());
		}
	},
	
	ENTRY_MONTH("%{news_month}"){
		@Override
		public String pattern() {
			return "\\d{2}";
		}

		@Override
		public String encode(Entry obj) {
			return getDateString("MM", ((Entry)obj).getPublishedDate());
		}
	},
	
	ENTRY_DAY("%{news_day}"){
		@Override
		public String pattern() {
			return "\\d{2}";
		}

		@Override
		public String encode(Entry obj) {
			return getDateString("dd", ((Entry)obj).getPublishedDate());
		}
	};
	
	private String variable;

	private NewsPermalinkVariable(String variable) {
		this.variable = variable;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public abstract String pattern() ;
	
	public abstract String encode(Entry obj);
	
	private static String getDateString(String pattern, Date date){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

}
