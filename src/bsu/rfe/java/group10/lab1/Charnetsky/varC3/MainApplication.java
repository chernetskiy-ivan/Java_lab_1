package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

import java.io.BufferedReader;
import java.lang.reflect.Constructor;

public class MainApplication {
    @SuppressWarnings("unchecked") //Почему он подчеркивает myClass.getConstructor если убрать подавление предупреждений т.е. о чем он меня пытается предупредить?
    public static void main(String[] args) throws Exception {
        Food[] Breakfast = new Food[20];
        int itemsSoFar = 0;

        for (String arg : args){
            String[] parts = arg.split("/");
            try{
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Charnetsky.varC3." + parts[0]);
                if(parts.length == 1){
                    Constructor constructor = myClass.getConstructor();
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance();
                    itemsSoFar++;
                }
                if(parts.length == 2){
                    Constructor constructor = myClass.getConstructor(String.class);
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                    itemsSoFar++;
                }
                if(parts.length == 3){
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1],parts[2]);
                    itemsSoFar++;
                }
            }
            catch(ClassNotFoundException e){
                System.out.println("Класс '" + parts[0] + "' не найден" + e);
            }
            catch(NoSuchMethodException eh){
                System.out.println("Метод не найден" + eh);
            }
        }
        for (int j = 0; j < itemsSoFar;j++) {
            System.out.println(Breakfast[j]);
        }

    }
}