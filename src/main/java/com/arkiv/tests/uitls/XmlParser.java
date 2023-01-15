package com.arkiv.tests.uitls;

import com.arkiv.tests.models.Book;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlParser {
    private static final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    private static final String BOOKS_XML = "C:\\Users\\privat\\IdeaProjects\\tests\\src\\main\\resources\\books.xml";
    public static List<Book> parseBookObjects() {
        List<Book> booksList = null;
        try {
            var saxParser = saxParserFactory.newSAXParser();
            var saxEventHandler = new SaxEventHandler();
            saxParser.parse(new File(BOOKS_XML), saxEventHandler);
            booksList = saxEventHandler.getBookList();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return booksList;
    }
}
