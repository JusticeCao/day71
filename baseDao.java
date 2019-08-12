package com.util.Dao;

import java.sql.*;
import java.util.ArrayList;

public class baseDao {
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/demo5";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    public Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeAll(Connection conn, Statement sta, ResultSet rs){
        try {
            if (rs!=null) rs.close();
            if (sta!=null) sta.close();
            if (conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql, ArrayList<Object> list){
        Connection conn=null;
        PreparedStatement pra=null;
        ResultSet rs=null;
        int rows=0;

        try {
            conn=this.getConnection();
            pra=conn.prepareStatement(sql);
            if (list!=null&&list.size()>0){
                for (int i=0;i<list.size();i++){
                    pra.setObject(i+1,list.get(i));
                }
            }
            rows=pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn,pra,rs);
        }
        return rows;
    }
}
