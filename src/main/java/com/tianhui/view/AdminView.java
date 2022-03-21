package com.tianhui.view;

import com.tianhui.po.Admin;

import java.sql.SQLException;

public interface AdminView {
    public Admin login() throws SQLException;

}
