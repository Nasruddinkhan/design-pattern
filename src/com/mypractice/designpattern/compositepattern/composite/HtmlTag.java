package com.mypractice.designpattern.compositepattern.composite;

import java.util.List;

public abstract class HtmlTag {
    public abstract void setStartTag(String tag);

    public abstract void setEndTag(String tag);

    public abstract String getTagName();

    public void setTagBody(String tagBody) {
        throw new UnsupportedOperationException("current operation is not support for this object");
    }

    public void addChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("current operation is not support for this object");
    }

    public void removeChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("current operation is not support for this object");
    }

    public List<HtmlTag> getChildren() {
        throw new UnsupportedOperationException("current operation is not support for this object");
    }

    public abstract void generateHtml();
}
