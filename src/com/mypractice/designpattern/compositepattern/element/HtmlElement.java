package com.mypractice.designpattern.compositepattern.element;

import com.mypractice.designpattern.compositepattern.composite.HtmlTag;

public class HtmlElement extends HtmlTag {
    private String tagName;
    private String startTag;
    private String endTag;
    private String tagBody;

    public HtmlElement(String tagName) {
        this.tagName = tagName;
        this.startTag = "";
        this.endTag = "";
        this.tagBody = "";
    }

    @Override
    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
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
    public void generateHtml() {
        System.out.println(startTag+""+tagBody+""+endTag);
    }

}
