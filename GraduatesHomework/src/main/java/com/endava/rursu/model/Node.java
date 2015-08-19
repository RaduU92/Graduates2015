package com.endava.rursu.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rursu on 8/18/2015.
 */
@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String json;
    @ManyToOne(optional = true)
    private Node parent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Node> childrens;

    public Node(String json, Node parent, List<Node> childrens) {
        this.json = json;
        this.parent = parent;
        this.childrens = childrens;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
}
