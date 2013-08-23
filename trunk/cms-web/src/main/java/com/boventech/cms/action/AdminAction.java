package com.boventech.cms.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.boventech.cms.action.personal.StatusMarker;
import com.boventech.util.user.UserRight;
import com.boventech.web.annotation.RequireLogin;
import com.boventech.web.annotation.RequireRight;

@Results({
	@Result(name = "noRight", type = "dispatcher", location = "noRight.jsp")
})
@RequireLogin
@RequireRight(right = UserRight.ADMIN)
public abstract class AdminAction extends AbstractAction implements StatusMarker{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6472043543335598172L;

	private static final String ADMIN_PATTERN = "/admin/";

	private static final String SLASH = "/";
	
	public String getCurrent() {
		String url = getCurrentUrl();
		if(url != null){
			int admin = url.indexOf(ADMIN_PATTERN);
			if(admin != -1){
				int start = admin + ADMIN_PATTERN.length();
				int end = url.indexOf(SLASH, start);
				return (end != -1) ? url.substring(start, end):url.substring(start);
			}
		}
		return "";
	}
}
