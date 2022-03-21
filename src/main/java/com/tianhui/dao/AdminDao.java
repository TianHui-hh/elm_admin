package com.tianhui.dao;

import com.tianhui.po.Admin;

import java.sql.SQLException;

public interface AdminDao {

    public Admin getAdminByNameByPass(String adminName, String password) throws SQLException;


}
