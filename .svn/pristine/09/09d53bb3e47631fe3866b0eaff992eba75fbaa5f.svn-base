package com.boventech.cms.service.open;

import java.util.List;

import com.boventech.cms.module.open.FriendlyLink;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.BasicService;

public interface FriendlyLinkService extends BasicService<FriendlyLink>{

    List<FriendlyLink> list(PageIndex pageIndex);

    int count();

    FriendlyLink getByPosition(int i);

    void deleteSelected(String[] selectLink);

    List<FriendlyLink> listByPosition(PageIndex pageIndex, boolean b);

    void cleanPosition(FriendlyLinkType friendlyLinkType);

    List<FriendlyLink> list();

	List<FriendlyLink> listByPosition(boolean desc);

	List<FriendlyLink> listByTypeAndPosition(FriendlyLinkType type, boolean desc);

	int count(FriendlyLinkType type);

	FriendlyLink getByTypeAndPosition(FriendlyLinkType type, int position);

}
