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

package com.boventech.sacwh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boventech.cms.module.user.User;
import com.boventech.cms.service.user.UserService;
import com.boventech.util.file.Md5Util;
import com.boventech.util.user.UserRight;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/*Context.xml"})
public class UserServiceTest {

    private static final String LOWER_E = "e";
    
    private static final String UPPER_E = "E";

    private static final char C_POINT = '.';

    private static final String POINT = ".";

    private static final char C_ZERO = '0';
    
    private static final char DBC_BLANK = (char) 32;

    private static final char SBC_BLANK = (char) 12288;

    private File file;

    private static final String filename = "users.xls";
    
    private UserService userService;
    
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Before
    public void initFile(){

        URL url = this.getClass().getClassLoader().getResource(filename);
        this.file = new File(url.getPath());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:**/*Context.xml");
         this.userService = (UserService)context.getBean("userService"); 
    }
    
    @Test
    public void addUser(){
        HSSFWorkbook workbook = getWorkBook(this.file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        List<User> users = new ArrayList<User>();
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            HSSFRow row = sheet.getRow(i);
            User user = new User();
            for (short j = 0; j < 13; j++) {
                String value = getCellValue(row, j);
                // System.out.print(value+" ");
                switch (j) {
                case 0:
                     user.setUsername(value);
                    break;
                case 1:
                    user.setAppendix(value);
                   break;
                case 2:
                    user.setPassword(Md5Util.encodeByMd5(value));
                    break;
                case 3:
                    user.setAddress(value);
                    break;
                case 4:
                    user.setPhone(value);
                    break;
                default:
                    break;
                }
            }
            if (user.getUsername() != null && user.getUsername().length() > 0) {
                users.add(user);
            }
        }
        for (User user : users) {
            user.setActivated(true);
            user.setUserRight(UserRight.NORMAL);
            this.userService.save(user);
        }
        
    }
    
    /**
     * 从文件流获取工作表
     * 
     * @param excelFile
     *            文件
     * @return 工作表
     */
    protected HSSFWorkbook getWorkBook(File excelFile) {
        POIFSFileSystem fileSystem = null;
        HSSFWorkbook workbook = null;
        try {
            fileSystem = new POIFSFileSystem(new FileInputStream(excelFile));
            workbook = new HSSFWorkbook(fileSystem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
    

    /**
     * 获取行row内序号为index的单元格的值
     * 
     * @param row
     *            行
     * @param index
     *            序号
     * @return 单元格的值
     */
    @SuppressWarnings("deprecation")
    protected String getCellValue(HSSFRow row, short index) {
        String value = null;
        if (row != null) {
            if (index < row.getLastCellNum()) {
                HSSFCell cell = row.getCell(index);
                if (cell != null) {
                    int type = cell.getCellType();
                    //value = trim(cell.getCellFormula());
                    if (type == 0) {
                        long temp = (long) cell.getNumericCellValue();
                        value = String.valueOf(temp);
                        //value = formatNumericValue(temp);
                    } else if (type == 1)
                        value = trim(cell.getStringCellValue());
                    else
                        return null;
                }
            }
        }
        return value;
    }
    

    /**
     * 将double类型的数转换为最简的字符串
     * 
     * @param temp
     *            double数
     * @return 字符串
     */
    public static String formatNumericValue(double temp) {
        String value = String.valueOf(temp);
        if (value != null && (value.indexOf(UPPER_E) >= 0 || value.indexOf(LOWER_E) >= 0)) {
            return String.valueOf((int) temp);
        }
        int locate = value.indexOf(POINT);
        if (locate >= 0) {
            StringBuffer buffer = new StringBuffer(value);
            for (int i = value.length() - 1; i >= locate; i--) {
                if (buffer.charAt(i) == C_ZERO)
                    buffer.deleteCharAt(i);
                else if (buffer.charAt(i) == C_POINT) {
                    buffer.deleteCharAt(i);
                    break;
                } else
                    break;
            }
            value = buffer.toString();
        }
        return value;
    }
    
    /**
     * 对任意字符串进行trim操作，并用半角空格代替全角空格
     * 
     * @param value
     *            待trim的值
     * @return trim操作后的值
     */
    public static String trim(final String value) {
        if (value != null && value.length() > 0) {
            String temp = value.trim();
            temp = temp.replace(SBC_BLANK, DBC_BLANK);
            return temp.trim();
        }
        return null;
    }
}
