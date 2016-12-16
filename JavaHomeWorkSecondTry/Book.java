
package com.mycompany.library;

public class Book {
    private TypeOfBook type;
    private String author;
    private String title;
    private String key;

    public Book(TypeOfBook type, String author, String title, String key) {
        this.type = type;
        this.author = author;
        this.title = title;
        this.key = key;
    }
    @Override
    public String toString() {
        return "type:" + type + ", author:" + author + ", title:" + title + ", key:" + key;
    }
    public TypeOfBook getType() {
        return type;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getKey() {
        return key;
    }  
}
