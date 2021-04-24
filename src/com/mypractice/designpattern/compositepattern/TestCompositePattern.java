package com.mypractice.designpattern.compositepattern;

import com.mypractice.designpattern.compositepattern.composite.HtmlTag;
import com.mypractice.designpattern.compositepattern.element.HtmlElement;
import com.mypractice.designpattern.compositepattern.parent.HtmlParentElement;

/**
 * When we want to re present part whole hierachies of object
 */
public class TestCompositePattern {
    public static void main(String[] args) {
        HtmlTag parentTag = new HtmlParentElement("<html>");
        parentTag.setStartTag("<html>");
        parentTag.setEndTag("</html>");

        HtmlTag bodyTag = new HtmlParentElement("<body>");
        bodyTag.setStartTag("<body>");
        bodyTag.setEndTag("</body>");
        parentTag.addChildTag(bodyTag);

        HtmlTag elementTag = new HtmlElement("<h1>");
        elementTag.setStartTag("<h1>");
        elementTag.setEndTag("</h1>");
        elementTag.setTagBody("Testing H1 Tag");
        bodyTag.addChildTag(elementTag);

        elementTag = new HtmlElement("<p>");
        elementTag.setStartTag("<p>");
        elementTag.setEndTag("</p>");
        elementTag.setTagBody("Testing p Tag");
        bodyTag.addChildTag(elementTag);

        parentTag.generateHtml();
    }
}
