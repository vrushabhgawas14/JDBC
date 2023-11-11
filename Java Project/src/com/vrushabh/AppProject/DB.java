package com.vrushabh.AppProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection conn = null;

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:Your-PortNumber/";
            String db = "Your Database Name";
            String userName = "Your UserName";
            String password = "Your Password";

            conn = DriverManager.getConnection(url + db, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
