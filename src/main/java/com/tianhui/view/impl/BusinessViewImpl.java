package com.tianhui.view.impl;

import com.tianhui.dao.BusinessDao;
import com.tianhui.dao.impl.BusinessDaoImpl;
import com.tianhui.po.Business;
import com.tianhui.view.BusinessView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() throws SQLException {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t   商家名称\t   商家地址\t   商家介绍\t   起送费\t   配送费\n");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t   " + b.getBusinessName() + "\t   " + b.getBusinessAddress() + "\t   " + b.getBusinessExplain() + "\t   " + b.getStarPrice() + "\t   " + b.getDeliveryPrice());
        }

    }

    @Override
    public void listBusiness() throws SQLException {
        String businessName = " ";
        String businessAddress = " ";

        String inputStr = "";
        System.out.println("是否需要输入商家名称作为查询条件y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键字");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址作为查询条件y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键字");
            businessAddress = input.next();
        }

        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t   商家名称\t   商家地址\t   商家介绍\t   起送费\t   配送费\n");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t   " + b.getBusinessName() + "\t   " + b.getBusinessAddress() + "\t   " + b.getBusinessExplain() + "\t   " + b.getStarPrice() + "\t   " + b.getDeliveryPrice());
        }


    }
}
