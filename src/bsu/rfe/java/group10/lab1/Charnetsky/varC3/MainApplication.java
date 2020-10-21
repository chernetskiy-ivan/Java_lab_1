package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

import java.lang.reflect.Constructor;

public class MainApplication {
    @SuppressWarnings("unchecked") //Почему он подчеркивает myClass.getConstructor если убрать подавление предупреждений т.е. о чем он меня пытается предупредить?
    public static void main(String[] args) throws Exception {
        Food[] Breakfast = new Food[20];
        int itemsSoFar = 0;
        boolean case1 = false;

        for (String arg : args) {
            String[] parts = arg.split("/");
            try {
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Charnetsky.varC3." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance();
                    itemsSoFar++;
                }
                if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                    itemsSoFar++;
                }
                if (parts.length == 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    Breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1], parts[2]);
                    itemsSoFar++;
                }
            } catch (ClassNotFoundException e) {
                switch (parts[0]) {
                    case "-calories":
                        case1 = true;
                        break;
                    default:
                        System.out.println("Класс '" + parts[0] + "' не найден" + e);
                        break;
                }
            } catch (NoSuchMethodException eh) {
                System.out.println("Метод не найден" + eh);
            }
        }

        if(case1){
            Double ALL_calories = 0.0;
            for(Food item : Breakfast){
                if(item != null){
                    ALL_calories += item.CalculateCalories();
                }
            }
            System.out.println("Калорийность завтрака " + ALL_calories);
        }

    }
}