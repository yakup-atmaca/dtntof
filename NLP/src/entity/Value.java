/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;

public class Value implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer valueId;

    private String valueName;

    private List<News> newsList;

    public Value() {
    }

    public Value(Integer valueId) {
        this.valueId = valueId;
    }

    public Value(Integer valueId, String valueName) {
        this.valueId = valueId;
        this.valueName = valueName;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
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
        hash += (valueId != null ? valueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Value)) {
            return false;
        }
        Value other = (Value) object;
        if ((this.valueId == null && other.valueId != null) || (this.valueId != null && !this.valueId.equals(other.valueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Value[ valueId=" + valueId + " ]";
    }

}
