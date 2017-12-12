package dao;

import entity.News;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NewsDao {

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

    public ArrayList<News> getNewsList() throws SQLException {

        ArrayList<News> listNews = new ArrayList<>();

        try {
            connect();

            String sorgu = "select * from news order by NewsId";

            pstmt = conn.prepareStatement(sorgu);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt("NewsId"));
                news.setDataSetId(rs.getString("DataSetId"));
                news.setNewsDate(rs.getString("NewsDate"));
                news.setActors(rs.getString("Actors"));
                news.setSentiment(rs.getString("Sentiment"));
                news.setType(rs.getString("Type"));
                news.setValue(rs.getString("Value"));
                news.setFakeTruthMatchNewsId(rs.getString("FakeTruthMatchNewsId"));
                news.setTopic(rs.getString("Topic"));
                news.setUrl(rs.getString("Url"));
                news.setNewsTitle(rs.getString("NewsTitle"));
                news.setNewsDetail(rs.getString("NewsDetail"));
                news.setGdeltFactor(rs.getString("GdeltFactor"));
                news.setGlobalEventId(rs.getString("GlobalEventId"));

                listNews.add(news);
            }

          close();

            return listNews;
        } catch (Exception e) {
            pstmt.close();
            rs.close();
            conn.close();
            e.printStackTrace();
            return null;
        }
    }

    public void fillTable(JTable table) throws ClassNotFoundException, IOException {

        try {
            String query = "select * from news order by NewsId";

            connect();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(query);

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }

          close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
