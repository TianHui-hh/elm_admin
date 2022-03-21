package com.tianhui.view.impl;

import com.tianhui.dao.AdminDao;
import com.tianhui.dao.impl.AdminDaoImpl;
import com.tianhui.po.Admin;
import com.tianhui.view.AdminView;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    private Scanner input = new Scanner(System.in);


    @Override
    public Admin login() throws SQLException {
        System.out.println("请输入管理员姓名:\n");
        String adminName = input.next();
        System.out.println("请输入管理员密码:\n");
        String password = input.next();

        AdminDao dao = new AdminDaoImpl();
        Admin admin = dao.getAdminByNameByPass(adminName, password);

        return dao.getAdminByNameByPass(adminName, password);
    }
}
