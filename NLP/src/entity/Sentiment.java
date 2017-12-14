/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;

public class Sentiment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sentimentId;

    private String sentimentName;

    private List<News> newsList;

    public Sentiment() {
    }

    public Sentiment(Integer sentimentId) {
        this.sentimentId = sentimentId;
    }

    public Sentiment(Integer sentimentId, String sentimentName) {
        this.sentimentId = sentimentId;
        this.sentimentName = sentimentName;
    }

    public Integer getSentimentId() {
        return sentimentId;
    }

    public void setSentimentId(Integer sentimentId) {
        this.sentimentId = sentimentId;
    }

    public String getSentimentName() {
        return sentimentName;
    }

    public void setSentimentName(String sentimentName) {
        this.sentimentName = sentimentName;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sentimentId != null ? sentimentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sentiment)) {
            return false;
        }
        Sentiment other = (Sentiment) object;
        if ((this.sentimentId == null && other.sentimentId != null) || (this.sentimentId != null && !this.sentimentId.equals(other.sentimentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sentiment[ sentimentId=" + sentimentId + " ]";
    }

}
