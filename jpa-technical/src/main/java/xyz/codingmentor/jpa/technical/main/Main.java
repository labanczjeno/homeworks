package xyz.codingmentor.jpa.technical.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.jpa.technical.application.Application;

/**
 *
 * @author blazefury
 */
public class Main {

    private Main() {
        //hiding public constructor
    }

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        Application application = container.instance().select(Application.class).get();
        application.execute();

        weld.shutdown();

    }

}
