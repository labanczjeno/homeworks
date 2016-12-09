package LTD;
import java.util.ArrayList;

public class LTD {
    private ArrayList<Human> list=new ArrayList<>();
    private String seat;
    private String name;
    private String scopeOfActivity;
    protected int fortune;
    private int worker;
    private int boss;

    @Override
    public String toString() {
        return "LTD{" + "list=" + list + ", seat=" + seat + ", name=" + name + ", scopeOfActivity=" + scopeOfActivity + ", fortune=" + fortune + ", worker=" + worker + ", boss=" + boss + '}';
    }

    public LTD(String seat, String name, String scopeOfActivity, int fortune, int worker, int boss) {
        this.seat = seat;
        this.name = name;
        this.scopeOfActivity = scopeOfActivity;
        this.fortune = fortune;
        this.worker = worker;
        this.boss = boss;
    }
    public ArrayList<Human> getList(){
        return list;
    }
    public void hireWorker(Worker w){
        list.add(w);
    }
    public void hireBoss(Boss b){
        list.add(b);
    }
    public void fireWorker(Worker w){
        list.remove(w);
    }
    public void fireBoss(Boss b){
        list.remove(b);
    }
    public void paySalary(int i){
        fortune-=i;
    }
    public static void print(ArrayList<Human> list) {
        list.forEach((l) -> {
            System.out.println(l);
        });
    }
    public static void main(String[] args) {
        Boss h1=new Boss("Christine","1995.02.27.",200000,10000);
        Boss h2=new Boss("Isabelle","1995.12.06.",150000,10000);
        Worker w1=new Worker("Eugene","1993.10.11.",27000,2500);
        Worker w2=new Worker("Simon","1995.12.21.",25000,2500);
        Worker w3=new Worker("Jack","1990.09.30.",22000,2500);
        Worker w4=new Worker("John","1997.03.18.",30000,2500);
        LTD l1=new LTD("Mexico","La Isla Diablo","Making English courses.",5000000,4,2);
        ArrayList<Human> list = l1.getList();
        
        l1.hireBoss(h1);
        l1.hireBoss(h2);
        l1.hireWorker(w1);
        l1.hireWorker(w2);
        l1.hireWorker(w3);
        l1.hireWorker(w4);
        l1.fireWorker(w4);
        l1.paySalary(h1.salary+h2.salary+w1.salary+w2.salary+w3.salary+w4.salary);
        System.out.println(l1.fortune);
        print(list);
    }
}

