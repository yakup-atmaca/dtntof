/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;



/**
 *
 * @author Yakup
 */
public class DataSet implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer dataSetId;

    private String dataSetName;

    private List<News> newsList;

    public DataSet() {
    }

    public DataSet(Integer dataSetId) {
        this.dataSetId = dataSetId;
    }

    public DataSet(Integer dataSetId, String dataSetName) {
        this.dataSetId = dataSetId;
        this.dataSetName = dataSetName;
    }

    public Integer getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(Integer dataSetId) {
        this.dataSetId = dataSetId;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
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
        hash += (dataSetId != null ? dataSetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSet)) {
            return false;
        }
        DataSet other = (DataSet) object;
        if ((this.dataSetId == null && other.dataSetId != null) || (this.dataSetId != null && !this.dataSetId.equals(other.dataSetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dataset[ dataSetId=" + dataSetId + " ]";
    }
    
}
