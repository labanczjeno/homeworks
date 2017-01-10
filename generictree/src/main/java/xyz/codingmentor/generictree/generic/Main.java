
package xyz.codingmentor.generictree.generic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private Main() {
        //hide default constructor
    }

    public static void main(String[] args) {
        GenericTree<String> tree = new GenericTree<>();

        Bulge<String> rootA = new Bulge<>("A");
        Bulge<String> childB = new Bulge<>("B");
        Bulge<String> childC = new Bulge<>("C");
        Bulge<String> childD = new Bulge<>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);
        LOGGER.log(Level.INFO, tree.toString());
    }
}
