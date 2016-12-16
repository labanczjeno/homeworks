
package com.mycompany.library;

import java.util.HashMap;
import java.util.Map;

public class Archive {
    private static Archive instance;
    private final Map<Book, Borrow> archiveMap;
    
    private Archive() {
        archiveMap = new HashMap<>();
    }
    public static Archive getInstance() {
        if(null == instance) {
            instance = new Archive();
        }
        return instance;
    }
    public Map<Book, Borrow> getArchive() {
        return archiveMap;
    }
    public void addBorrowBook(Book book,String date,String name) {
        if(archiveMap.containsKey(book)) {
            Borrow detail = archiveMap.get(book);
            if(detail.isBorrowed()) {
                throw new TheBookIsBorrowedException();
            }
        }
        else {
            archiveMap.put(book, new Borrow(name,date));
        }
    }
    public void bookBack(Book book, String date) {
        if(archiveMap.containsKey(book)) {
            Borrow borrow = archiveMap.get(book);
            if(borrow.isBorrowed()) {
                borrow.setBookBack(date);
                archiveMap.put(book, borrow);
            }
        }
    }
}
