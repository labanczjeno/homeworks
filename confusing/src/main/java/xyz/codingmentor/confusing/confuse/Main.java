
package xyz.codingmentor.confusing.confuse;

@Confusion
public class Main {

    private Main() {
        //empty on purpose
    }

    public static void main(String[] args) {
        Reflection.analyze(Main.class);
    }
    
    @Confusion
    public static void confusion(){
        //empty on purpose
    }
}