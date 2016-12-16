
package com.mycompany.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private Archive archivee;
    
    public Library() {
        bookList = new ArrayList<>();
        archivee = Archive.getInstance();
    } 
    @Override
    public String toString() {
        return "typeList:" + bookList + ", archive:" + archivee;
    } 
    public void listAddBook(Book book) {
        bookList.add(book);
    } 
    public void borrow(Book book, String name, String date) {
        archivee.addBorrowBook(book,name,date);
    }
    public void bookBack(Book book, String date) {
        archivee.bookBack(book, date);
    }
    public Book getItem(int item) {
        return bookList.get(item-1);
    }
}
