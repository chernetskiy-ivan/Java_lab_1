package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

public abstract class Food implements Consumable{
    //пока не надо
//    @Override
//    public void consume(){
//        // TODO Auto-generated method stub
//    }
    String name = null;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Food(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name==null || ((Food)arg0).name==null) return false; //Шаг 2
        return name.equals(((Food)arg0).name); // Шаг 3
    }
}
