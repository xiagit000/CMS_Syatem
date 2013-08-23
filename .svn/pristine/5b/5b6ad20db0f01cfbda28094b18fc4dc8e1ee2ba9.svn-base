package com.boventech.permalink.entity;

import com.boventech.permalink.PermalinkVariable;


public enum NewsPermalinkVariable  implements PermalinkVariable<News>{
	        ENTRY_ID("%{news_id}"){
	                @Override
	                public String pattern() {
	                        return "(\\d+)";
	                }
	                public String encode(News obj) {
	                        return obj.id.toString();
	                }
	                
	        },
	        
	        ENTRY_YEAR("%{news_year}"){
	                @Override
	                public String pattern() {
	                        return "(\\d{4})";
	                }
	                @Override
	                public String encode(News obj) {
	                        return String.valueOf(((News)obj).year);
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
	        
	        public abstract String encode(News obj);
	        
	       
}
