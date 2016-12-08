package LTD;

public class Boss extends Human {
    public Boss(String name, String dateOfBirth, int fortune, int salary) {
        super(name, dateOfBirth, fortune, salary);
    }
    @Override
    public void work(){
        System.out.println(name+"is working at the moment");
    }
}
