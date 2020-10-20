package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

public class Desert extends Food{

    private String Par1 = null;
    private String Par2 = null;


    public Desert( String Par1, String Par2){
        super("Десерт");
        this.Par1 = Par1;
        this.Par2 = Par2;
    }

    public String getPar1(){
        return Par1;
    }

    public String getPar2(){
        return Par2;
    }

    public void setPar1(String InputPar1){
        this.Par1 = InputPar1;
    }

    public void setPar2(String InputPar2){
        this.Par2 = InputPar2;
    }

    public void consume(){
        System.out.println(this + " и он весь съеден");
    }

    public String toString() {
        return super.toString() + " состоит из " + this.Par1 + " и " + this.Par2;
    }

    public boolean equals(Object arg0){
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Desert)) return false;
            return (Par1.equals(((Desert)arg0).Par1) && Par2.equals(((Desert)arg0).Par2));
        } else
            return false;
    }
}
