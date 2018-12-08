package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class EUTreeNode {
    private Long id;
    private Long pid;
    private String text;
    private List<EUTreeNode> children = new ArrayList<>(0);

    public List<EUTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<EUTreeNode> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
