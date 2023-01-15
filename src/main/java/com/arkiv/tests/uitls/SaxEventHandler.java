package com.arkiv.tests.uitls;

import com.arkiv.tests.models.Book;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SaxEventHandler extends DefaultHandler {
    // List to hold Books object
    private List<Book> bookList = null;
    private Book book = null;
    private StringBuilder data = null;

    // Getter method for Book list
    public List<Book> getBookList() {

        return bookList;
    }
    boolean isAuthor = false;
    boolean isTitle = false;
    boolean isGenre = false;
    boolean isPrice = false;
    boolean isPublishDate = false;
    boolean isDescription = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("book")) {
            // create a new Book and put it in Map
            String id = attributes.getValue("id");
            // initialize Book object and set id attribute
            book = new Book();
            book.setId(id);
            // initialize list
            if (bookList == null) {
                bookList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("author")) {
            // set boolean values for fields, will be used in setting Book variables
            isAuthor = true;
        } else if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            isGenre = true;
        } else if (qName.equalsIgnoreCase("price")) {
            isPrice = true;
        }else if (qName.equalsIgnoreCase("publish_date")) {
            isPublishDate = true;
        }else if (qName.equalsIgnoreCase("description")) {
            isDescription = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isAuthor) {
            book.setAuthor(data.toString());
            isAuthor = false;
        } else if (isTitle) {
            book.setTitle(data.toString());
            isTitle = false;
        } else if (isGenre) {
            book.setGenre(data.toString());
            isGenre = false;
        } else if (isPrice) {
            book.setPrice(Double.parseDouble(data.toString()));
            isPrice = false;
        } else if (isPublishDate) {
            book.setPublish_date(data.toString());
            isPublishDate = false;
        } else if (isDescription) {
            book.setDescription(data.toString());
            isDescription = false;
        }

        if (qName.equalsIgnoreCase("book")) {
            // add Book object to list
            bookList.add(book);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
