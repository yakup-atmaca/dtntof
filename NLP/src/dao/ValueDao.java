package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.DataSource;

public class ValueDao {

    DataSource ds;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    private void connect() throws SQLException, ClassNotFoundException, IOException {
        MyDataSource myDataSource = new MyDataSource();
        ds = myDataSource.getMySQLDataSource();
        conn = ds.getConnection();
    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap hashMap() throws ClassNotFoundException, IOException {
        try {

            HashMap hashMap = new HashMap();

            String query = "SELECT ValueId, ValueName FROM value order by ValueId";

            connect();
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    hashMap.put(rs.getInt("ValueId"), rs.getString("ValueName"));
                }
            }

            close();

            return hashMap;
        } catch (SQLException e) {
            close();
            e.printStackTrace();
            return null;
        }
    }
}
