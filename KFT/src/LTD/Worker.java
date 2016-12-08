package LTD;

public class Worker extends Human{
    public Worker(String name, String dateOfBirth, int fortune, int salary) {
        super(name, dateOfBirth, fortune, salary);
    }
    @Override
    public void work(){
        System.out.println(name+"is having a lecture at the moment.");
    }
}
