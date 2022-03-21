package com.tianhui.view;

import java.sql.SQLException;

public interface BusinessView {
    public void listBusinessAll() throws SQLException;
    public void listBusiness() throws SQLException;
}
