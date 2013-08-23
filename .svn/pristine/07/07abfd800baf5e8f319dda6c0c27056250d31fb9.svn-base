/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.sacwh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.cms.dao.node.CommentDao;
import com.boventech.cms.dao.user.UserDao;
import com.boventech.cms.module.node.Comment;
import com.boventech.cms.module.user.User;
import com.boventech.sacwh.service.EntryCommentService;
import com.boventech.util.user.UserRight;
import com.google.common.collect.Lists;

@Service
@Transactional
public class EntryCommentServiceImpl implements EntryCommentService{
    
    private UserDao userDao;
    
    private CommentDao commentDao;

    public void save(Comment t) {
        // TODO Auto-generated method stub
        
    }

    public void delete(Comment t) {
        // TODO Auto-generated method stub
        
    }

    public void update(Comment t) {
        // TODO Auto-generated method stub
        
    }

    public Comment findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<User> getNoCommenter(int entryId) {
        List<User> all = this.userDao.listByRight(UserRight.NORMAL);
        List<User> commenters = Lists.newArrayList();
        List<Comment> comments = this.commentDao.listByEntryId(entryId);
        for(Comment comment : comments){
            User user = comment.getUser();
            if(!commenters.contains(user)){
                commenters.add(user);
            }
        }
        all.removeAll(commenters);
        return all;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

}
