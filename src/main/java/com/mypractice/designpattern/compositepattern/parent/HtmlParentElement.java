package com.mypractice.designpattern.compositepattern.parent;

import com.mypractice.designpattern.compositepattern.composite.HtmlTag;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {
    private String tagName;
    private String startTag;
    private String endTag;
    private List<HtmlTag> childrenTag;

    public HtmlParentElement(String tagName) {
        this.tagName = tagName;
        this.startTag = "";
        this.endTag = "";
        this.childrenTag = new ArrayList<>();
    }


    @Override
    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    @Override
    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    @Override
    public String getTagName() {
        return tagName;
    }


    @Override
    public void removeChildTag(HtmlTag htmlTag) {
        childrenTag.remove(htmlTag);
    }

    @Override
    public List<HtmlTag> getChildren() {
        return childrenTag;
    }

    public void addChildTag(HtmlTag htmlTag) {
        childrenTag.add(htmlTag);
    }


    @Override
    public void generateHtml() {
        System.out.println(startTag);
        childrenTag.forEach(tag -> {
            tag.generateHtml();
        });
        System.out.println(endTag);
    }
}
