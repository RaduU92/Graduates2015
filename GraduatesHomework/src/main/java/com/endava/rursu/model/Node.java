package com.endava.rursu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by rursu on 8/18/2015.
 */
@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String json;
    private int parentId;

    public Node(String json, int parentId) {
        this.json = json;
        this.parentId = parentId;
    }

    public Node() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
