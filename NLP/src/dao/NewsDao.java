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

            String sorgu = "SELECT NewsId, d.*, NewsDate, Actors, s.*, ty.*, v.*, FakeTruthMatchNewsId,  t.*,  Url,  NewsTitle, NewsDetail\n"
                    + "FROM nlp.news n, nlp.dataset d, nlp.sentiment s, nlp.topic t, nlp.type ty, nlp.value v\n"
                    + "where n.DataSetId = d.DataSetId and n.SentimentId = s.SentimentId and n.TypeId = ty.TypeId and n.ValueId = v.ValueId and n.TopicId = t.TopicId order by NewsId";

            pstmt = conn.prepareStatement(sorgu);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                News news = new News();
                news.setNewsId(rs.getInt("NewsId"));
                news.getDataSetId().setDataSetId(rs.getInt("DataSetId"));
                news.getDataSetId().setDataSetName(rs.getString("DataSetName"));
                news.setNewsDate(rs.getDate("NewsDate"));
                news.setActors(rs.getString("Actors"));
                news.getSentimentId().setSentimentId(rs.getInt("SentimentId"));
                news.getSentimentId().setSentimentName(rs.getString("SentimentName"));
                news.getTypeId().setTypeId(rs.getInt("TypeId"));
                news.getTypeId().setTypeName(rs.getString("TypeName"));
                news.getValueId().setValueId(rs.getInt("ValueId"));
                news.getValueId().setValueName(rs.getString("ValueName"));
                news.setFakeTruthMatchNewsId(rs.getInt("FakeTruthMatchNewsId"));
                news.getTopicId().setTopicId(rs.getInt("TopicId"));
                news.getTopicId().setTopicName(rs.getString("TopicId"));
                news.setUrl(rs.getString("Url"));
                news.setNewsTitle(rs.getString("NewsTitle"));
                news.setNewsDetail(rs.getString("NewsDetail"));

                listNews.add(news);
            }

            close();

            return listNews;
        } catch (Exception e) {
            close();
            e.printStackTrace();
            return null;
        }
    }

    public void fillTable(JTable table) throws ClassNotFoundException, IOException {

        try {
            String query = "SELECT NewsId, d.DataSetName, NewsDate, Actors, s.SentimentName, ty.TypeName, v.ValueName, FakeTruthMatchNewsId,  t.TopicName,  Url,  NewsTitle, NewsDetail\n"
                    + "FROM nlp.news n, nlp.dataset d, nlp.sentiment s, nlp.topic t, nlp.type ty, nlp.value v\n"
                    + "where n.DataSetId = d.DataSetId and n.SentimentId = s.SentimentId and n.TypeId = ty.TypeId and n.ValueId = v.ValueId and n.TopicId = t.TopicId order by NewsId";

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

    public void addNews(News news) {

        try {
            String query = "INSERT INTO news(DataSetId,NewsDate,Actors,SentimentId,TypeId,ValueId,FakeTruthMatchNewsId,TopicId,Url,NewsTitle,NewsDetail)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            connect();

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, news.getDataSetId().getDataSetId());
            pstmt.setDate(2, (java.sql.Date) news.getNewsDate());
            pstmt.setString(3, news.getActors());
            pstmt.setInt(4, news.getSentimentId().getSentimentId());
            pstmt.setInt(5, news.getTypeId().getTypeId());
            pstmt.setInt(6, news.getValueId().getValueId());
            pstmt.setInt(7, news.getFakeTruthMatchNewsId());
            pstmt.setInt(8, news.getTopicId().getTopicId());
            pstmt.setString(9, news.getUrl());
            pstmt.setString(10, news.getNewsTitle());
            pstmt.setString(11, news.getNewsDetail());

            pstmt.executeUpdate();

            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateNews(News news) {

        try {
            String query = "UPDATE nlp.news\n"
                    + "SET DataSetId = ?, NewsDate = ?, Actors = ?, SentimentId = ?, TypeId = ?, ValueId =?, FakeTruthMatchNewsId = ?, TopicId = ?, Url = ?, NewsTitle = ?, NewsDetail = ?\n"
                    + "WHERE NewsId = ?";

            connect();

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, news.getDataSetId().getDataSetId());
            pstmt.setDate(2, (java.sql.Date) news.getNewsDate());
            pstmt.setString(3, news.getActors());
            pstmt.setInt(4, news.getSentimentId().getSentimentId());
            pstmt.setInt(5, news.getTypeId().getTypeId());
            pstmt.setInt(6, news.getValueId().getValueId());
            pstmt.setInt(7, news.getFakeTruthMatchNewsId());
            pstmt.setInt(8, news.getTopicId().getTopicId());
            pstmt.setString(9, news.getUrl());
            pstmt.setString(10, news.getNewsTitle());
            pstmt.setString(11, news.getNewsDetail());
            pstmt.setInt(12, news.getNewsId());

            pstmt.executeUpdate();

            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNews(News news) {

        try {
            String query = "delete from news WHERE `NewsId` = ?";

            connect();

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, news.getNewsId());

            pstmt.executeUpdate();

            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
