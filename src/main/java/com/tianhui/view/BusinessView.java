package com.tianhui.view;

import java.sql.SQLException;

public interface BusinessView {
    public void listBusinessAll() throws SQLException;
    public void listBusiness() throws SQLException;
    public void saveBusiness() throws SQLException;
    public void removeBusiness() throws SQLException;
}
