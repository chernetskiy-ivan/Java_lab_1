package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

public class Apple extends Food{
    private String size = null;
    private Double calories = null;

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public Apple(String size){
        super("Яблоко");
        this.size = size;
    }

    public void consume(){
        System.out.println(this + " съедено");
    }

    public String toString(){
        return super.toString() + " размера ' " + size.toUpperCase() + " ' ";
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public Double CalculateCalories(){
        switch (size) {
            case "Большое" -> calories = 10.0;
            case "Среднее" -> calories = 8.0;
            case "Маленькое" -> calories = 6.0;
        }
        return calories;
    }

    public int param(){
        return 1;
    }

}
