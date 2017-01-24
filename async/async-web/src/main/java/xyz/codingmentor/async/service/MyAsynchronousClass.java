package xyz.codingmentor.async.service;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import xyz.codingmentor.async.entity.Book;

/**
 *
 * @author blazefury
 */
public class MyAsynchronousClass {

    private static final Logger LOG = Logger.getLogger(MyAsynchronousClass.class.getName());

    @Asynchronous
    public void coffe() {
        LOG.log(Level.INFO, "Making coffe");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyAsynchronousClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Coffe has been made in {0} milliseconds", 20000);
    }

    @Asynchronous
    public Future<String> readBook(Book book) {
        LOG.log(Level.INFO, "Downloading is in process, do something meanwhile.");
        try {
            book.download(book);
            Thread.sleep(25000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyAsynchronousClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("Your book has been downloaded: " + book);
    }

}
