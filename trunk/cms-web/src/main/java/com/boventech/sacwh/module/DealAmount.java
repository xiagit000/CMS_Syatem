/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: 215 $
 * $Author: liang.zhou $
 * $LastChangedDate: 2012-12-06 11:38:57 +0800 (星期四, 06 十二月 2012) $
 *
 */

package com.boventech.sacwh.module;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 交易量
 * @author Blue
 *
 */
@Entity
@Table(name = "sacwh_dealamount")
public class DealAmount implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -989874720344167165L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String company;
    
    private int percent;
    
    private Date createTime = new Date();
    
    private Date updateTime;
    
    private Date dealTime;
    
//    private long amount;
    
    private double totalAmount; //交易金额
    
    private int orderBy;
    
    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmountString() {
        String tempA = totalAmount + "";
        boolean resultE = tempA.contains("E");
        if(resultE){
            String num=tempA.substring(tempA.indexOf('E')+1,tempA.length());
            int b=Integer.parseInt(num);
            tempA=tempA.substring(0,tempA.indexOf('.'))+tempA.substring(tempA.indexOf('.')+1,tempA.indexOf('E'));
            boolean result = tempA.length() > b;
            if(result){
                tempA=tempA.substring(0,b+1)+"."+tempA.substring(b+1,tempA.length());
            }
        }
        return tempA;
    }
    
    public void setTotalAmountString(String totalAmountString){
        double tempA = Double.parseDouble(totalAmountString);
        this.totalAmount = tempA;
    }
    
}
