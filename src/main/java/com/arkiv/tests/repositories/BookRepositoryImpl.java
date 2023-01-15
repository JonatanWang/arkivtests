package com.arkiv.tests.repositories;

import com.arkiv.tests.models.Book;
import com.arkiv.tests.uitls.XmlParser;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> list = XmlParser.parseBookObjects() ;
    @Override
    public List<Book> getAllBooks() {
        return list;
    }
    public Book findById(String id) {
        for (Book book : list) {
            if (book.getId().equals(id)) {

                return book;
            }
        }

        return null;
    }

    @Override
    public List<Book> search(String title) {

        var resultSet = new HashSet<Book>();
        var keywords = Arrays.stream(title.toLowerCase().split("\\s+")).toList();

        var tempList = new ArrayList<Book>();
        tempList.addAll(list);
        ListIterator<Book> iter = tempList.listIterator();
        while(iter.hasNext()){
            for (String keyword : keywords) {
                var book = iter.next();
                if(book.getTitle().toLowerCase().contains(keyword)){
                    resultSet.add(book);
                    iter.remove();
                }
            }
        }

//        for (String keyword: keywords) {
//            var partResult = list
//                    .stream()
//                    .filter(book -> book.getTitle()
//                            .toLowerCase()
//                            .contains(keyword))
//                    .collect(Collectors.toSet());
//            resultSet.addAll(partResult);
//        }

        return resultSet.stream().toList();
    }
}
