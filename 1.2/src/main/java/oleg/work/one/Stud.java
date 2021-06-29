package oleg.work.one;

public class Stud implements StudInterface {
    private int mark;
    private String name;

    public Stud(String name){
        this.name=name;
    }
    public Stud(){}
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){return name;}

    @Override
    public void setMark(int res){
        this.mark=res;
    }
    @Override
    public void getMark() {
        System.out.println("Student "+name+ " has "+mark+" points.");
    }

}
