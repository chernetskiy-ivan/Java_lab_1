package bsu.rfe.java.group10.lab1.Charnetsky.varC3;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        Food[] Breakfast = new Food[20];
        int itemsSoFar = 0;
        boolean case1, case2;
        case1 = case2 = false;

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
                    case "-sort":
                        case2 = true;
                        break;
                    default:
                        System.out.println("Класс '" + parts[0] + "' не найден" + e);
                        break;
                }
            } catch (NoSuchMethodException eh) {
                System.out.println("Метод не найден" + eh);
            }
        }

        Food j;
        boolean chek = true;
        int h = 0, i = 0, c = 0;
        int []a1 = new int[itemsSoFar];

        j = Breakfast[i];
        for(int k = 0; k < itemsSoFar;k++){
            if(Breakfast[k].equals(j)){
                h++;        // Сколько раз встретился этот продукт
                a1[k] = c; // Первые позиции
                c++;
            }
        }
        System.out.println(Breakfast[i] + " встретился в завтраке "+ h + " раз.");
        i++;
        h = 0;

        do{
            for(int p = i; p < itemsSoFar; p++) {
                if (a1[p] != i && a1[p] == 0 ) {
                    i = p; // Позиция нового не учтенного элемента
                    break;
                } else {
                    chek = false;
                }
            }
            if(chek) {
                j = Breakfast[i];
                for (int k = i; k < itemsSoFar; k++) {
                    if (Breakfast[k].equals(j)) {
                        h++;
                        a1[k] = c;
                    }
                }
                System.out.println(Breakfast[i] + " встречается в завтраке " + h + " раз");
                c++;
                h = 0;
            }
            i++;
        }while( i < itemsSoFar);

        System.out.println("Завтрак: "); //выводим завтрак таким,каким он был первоначально
        for (Food item : Breakfast) {
            if (item != null) {
                item.consume();
                System.out.println(" " + item.CalculateCalories());
            } else {
                break;
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


        if (case2) { //случай "ClassNotFoundException", когда мы задаем параметр -sort
            System.out.println("\n\nДо сортировки");
            for(int q =0;q < itemsSoFar;q++){
                System.out.println(Breakfast[q]);
            }
            Arrays.sort(Breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1 == null) return 1;
                    if (f2 == null) return -1;

                    if (((Food) f1).param() > ((Food) f2).param())
                        return 1;
                    else if (((Food) f1).param() < ((Food) f2).param())
                        return -1;
                    else
                        return 0;
                }
            });

            System.out.println("\n\nПосле сортировки");
            for(int q =0;q < itemsSoFar;q++){
                System.out.println(Breakfast[q]);
            }
        }
    }
}