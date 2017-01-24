
package xyz.codingmentor.async.entity;

/**
 *
 * @author blazefury
 */
public class Book {
    
    String title;
    String text;

    public Book(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void download(Book book){
        book.getText();
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", text=" + text + '}';
    }
    
}
