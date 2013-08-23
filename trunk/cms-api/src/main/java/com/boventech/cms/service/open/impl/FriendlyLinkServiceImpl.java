package com.boventech.cms.service.open.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.open.FriendlyLinkDao;
import com.boventech.cms.module.open.FriendlyLink;
import com.boventech.cms.module.open.FriendlyLinkType;
import com.boventech.cms.module.web.PageIndex;
import com.boventech.cms.service.open.FriendlyLinkService;
import com.boventech.util.math.Util;

@Service
@Transactional
public class FriendlyLinkServiceImpl implements FriendlyLinkService{
    
    private FriendlyLinkDao friendlyLinkDao;

    public List<FriendlyLink> list(PageIndex pageIndex) {
        return this.friendlyLinkDao.list(pageIndex);
    }

    public void setFriendlyLinkDao(FriendlyLinkDao friendlyLinkDao) {
        this.friendlyLinkDao = friendlyLinkDao;
    }

    public int count() {
        return this.friendlyLinkDao.count();
    }

    public void delete(FriendlyLink friendlyLink) {
        this.friendlyLinkDao.delete(friendlyLink);
    }

    public void save(FriendlyLink friendlyLink) {
        this.friendlyLinkDao.save(friendlyLink);
    }

    public void update(FriendlyLink friendlyLink) {
        this.friendlyLinkDao.update(friendlyLink);
    }

    public FriendlyLink findById(Integer linkId) {
        return this.friendlyLinkDao.findById(linkId);
    }

    public FriendlyLink getByPosition(int position) {
        List<FriendlyLink> links = this.friendlyLinkDao.findByPosition(position);
        return links != null && links.size() > 0 ? links.get(0) : null;
    }

    public void deleteSelected(String[] selectLink) {
        for(String link:selectLink){
            if(Util.isNumeric(link)){
                Integer linkId = Integer.valueOf(link);
                FriendlyLink friendlyLink = this.friendlyLinkDao.findById(linkId);
                this.friendlyLinkDao.delete(friendlyLink);
            }
        }
    }

    public List<FriendlyLink> listByPosition(PageIndex pageIndex, boolean desc) {
        return this.friendlyLinkDao.listByPosition(pageIndex, desc);
    }

    public void cleanPosition(FriendlyLinkType type) {
        List<FriendlyLink> links = this.friendlyLinkDao.listByTypeAndPosition(type, false);
        for(int i=0;i<links.size();i++){
            if(links.get(i).getPosition() != i+1){
                links.get(i).setPosition(i+1);
                this.friendlyLinkDao.update(links.get(i));
            }
        }
    }

    public List<FriendlyLink> list() {
        return this.friendlyLinkDao.list();
    }

	public List<FriendlyLink> listByPosition(boolean desc) {
		return this.friendlyLinkDao.listByPosition(desc);
	}

	public List<FriendlyLink> listByTypeAndPosition(FriendlyLinkType type,
			boolean desc) {
		return this.friendlyLinkDao.listByTypeAndPosition(type, desc);
	}

	public int count(FriendlyLinkType type) {
		return this.friendlyLinkDao.count(type);
	}

	public FriendlyLink getByTypeAndPosition(FriendlyLinkType type, int position) {
		return this.friendlyLinkDao.getByTypeAndPosition(type, position);
	}

}
