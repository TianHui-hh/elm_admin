package com.tianhui;

import com.tianhui.po.Admin;
import com.tianhui.view.AdminView;
import com.tianhui.view.BusinessView;
import com.tianhui.view.impl.AdminViewImpl;
import com.tianhui.view.impl.BusinessViewImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ElmAdminEntry {
    public void work() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|\t\t\t\t饿了么后台管理系统\t\t\t\t|");
        System.out.println("---------------------------------------------");

        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin = adminView.login();


        //登录
        if (admin != null) {
            int menu = 0;
            while (menu != 5) {
                //输出主菜单
                System.out.println("\n=========1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统=========");
                System.out.println("请输入你的选择:");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusiness();
                        break;
                    case 3:
                        System.out.println("新建商家");
                        break;
                    case 4:
                        System.out.println("删除商家");
                        break;
                    case 5:
                        System.out.println("----------------------------欢迎下次光临后台管理系统----------------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }

            }

        } else {
            System.out.println("管理员名称或密码输入错误\n");
        }
    }

    public static void main(String[] args) throws SQLException {
        new ElmAdminEntry().work();
    }
}
