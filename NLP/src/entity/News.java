/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer newsId;

    private Date newsDate;

    private String actors;

    private Integer fakeTruthMatchNewsId;

    private String url;

    private String newsTitle;

    private String newsDetail;

    private DataSet dataSetId;

    private Sentiment sentimentId;

    private Topic topicId;

    private Type typeId;

    private Value valueId;

    public News() {
    }

    public News(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Integer getFakeTruthMatchNewsId() {
        return fakeTruthMatchNewsId;
    }

    public void setFakeTruthMatchNewsId(Integer fakeTruthMatchNewsId) {
        this.fakeTruthMatchNewsId = fakeTruthMatchNewsId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public DataSet getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(DataSet dataSetId) {
        this.dataSetId = dataSetId;
    }

    public Sentiment getSentimentId() {
        return sentimentId;
    }

    public void setSentimentId(Sentiment sentimentId) {
        this.sentimentId = sentimentId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    public Value getValueId() {
        return valueId;
    }

    public void setValueId(Value valueId) {
        this.valueId = valueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "News[ newsId=" + newsId + " ]";
    }

}
