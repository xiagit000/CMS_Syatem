package com.boventech.cms.dao.open;

import java.util.List;

import com.boventech.cms.dao.AbstractDao;
import com.boventech.cms.module.open.FriendlyLink;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.module.web.PageIndex;

public interface FriendlyLinkDao extends AbstractDao<FriendlyLink, Integer>{

    List<FriendlyLink> listByPosition(PageIndex pageIndex, boolean desc);

    List<FriendlyLink> listByPosition(boolean desc);

	List<FriendlyLink> findByPosition(int position);

	List<FriendlyLink> listByTypeAndPosition(FriendlyLinkType type, boolean desc);

	int count(FriendlyLinkType type);

	FriendlyLink getByTypeAndPosition(FriendlyLinkType type, int position);

}
