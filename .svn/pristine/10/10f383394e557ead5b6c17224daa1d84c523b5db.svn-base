package com.boventech.cms.action.util;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * flash消息拦截器.其作用为在每次action请求之前重建上一次保存的flash消息,在action请求完成之后存储所有flash消息
 * 
 * @author xiedongming
 *
 */
public class FlashMessageInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	private final Log log = LogFactory.getLog(FlashMessageInterceptor.class);
	
	public void destroy() {
	}

	public void init() {
	}


	public String intercept(ActionInvocation ai) throws Exception {
		if(MessageFlashable.class.isAssignableFrom(ai.getAction().getClass())){
			String sessionID = ServletActionContext.getRequest().getSession().getId();
			if(sessionID!= null) {
				Map<String, Object> messages = FlashMessageContext.consumeMessages(sessionID);
				if(messages != null && !messages.isEmpty()) {
					/*为action重建flash消息,供存储和消费使用*/
					log.debug("restore flash messages from FlashMessageContext to action");
					((MessageFlashable)ai.getAction()).restoreMessages(messages);
				}
			}

			
			String result = ai.invoke();
		
			sessionID = ServletActionContext.getRequest().getSession().getId();
			Map<String, Object> messages = ((MessageFlashable)ai.getAction()).messagesToStore();
			if(sessionID != null && messages != null && !messages.isEmpty()){
				/*存储action需要保存的flash消息*/
				log.debug("store action's flash messages to FlashMessageContext");
				FlashMessageContext.registerMessages(sessionID, messages);
			} 
			
			return result;
		}
		return ai.invoke();
	}

}
