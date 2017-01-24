package xyz.codingmentor.async.restjeno.sonar;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.async.entity.Book;
import xyz.codingmentor.async.service.MyAsynchronousClass;

/**
 *
 * @author blazefury
 */
@Path("netcoffe")
@Produces(MediaType.TEXT_PLAIN)
public class NetCoffeRESTservice {

    private MyAsynchronousClass myAsynchronousClassExample = new MyAsynchronousClass();
    private static final Logger LOG = Logger.getLogger(NetCoffeRESTservice.class.getName());
    private Future<String> futureEx;
    private String result;

    /* Internetkávézó nagyvonalakban. Arra törekedtem,
       * hogy tudjam szemléltetni az asynchronous jelentőségét.
       * A kávékészítést és a könyvletöltést szál altatással szimuláltam.
       * http://localhost:8080/async-web/webservices/netcoffe/coffe
       * http://localhost:8080/async-web/webservices/netcoffe/book
     */
    @GET
    @Path("/coffe")
    public String voidEx() {
        myAsynchronousClassExample.coffe();
        LOG.log(Level.INFO, "Coffe is ok");
        return "your coffe is ready";
    }

    @GET
    @Path("/book")
    public String futureEx() {
        result = null;
        Book book = new Book("randombook", "randomtext");
        futureEx = myAsynchronousClassExample.readBook(book);
        LOG.log(Level.INFO, "Book is ok");
        try {
            result = futureEx.get();
        } catch (InterruptedException | ExecutionException iex) {
            Logger.getLogger(NetCoffeRESTservice.class.getName()).log(Level.SEVERE, null, iex);
        }
        return result;
    }

}
