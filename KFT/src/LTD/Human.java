package LTD;

public abstract class Human {
    protected String name;
    protected final String dateOfBirth;
    protected int fortune;
    protected int salary;

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", dateOfBirth=" + dateOfBirth + ", fortune=" + fortune + ", salary=" + salary + '}';
    }
    
    public Human(String name, String dateOfBirth, int fortune, int salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.fortune = fortune;
        this.salary = salary;
    }
    public abstract void work();
}
