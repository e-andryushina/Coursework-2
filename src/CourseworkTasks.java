import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseworkTasks {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        List<String> books = new ArrayList<>();
        books.add("Война и мир");
        books.add("Унесенные ветром");
        books.add("Рассказы");
        books.add("Чайка по имени Джонатан Ливингстон");
        books.add("Приключения Тома Сойера");
        books.add("Отцы и дети");
        books.add("Братья Карамазовы");
        books.add("Дама с собачкой");
        books.add("Преступление и наказание");
        books.add("Мост");
        books.add("English for beginners");


        List<ArrayList<String>> shelves = putBookOnShelves(books);

        for (ArrayList<String> shelf : shelves) {
            System.out.println(shelf);
        }

        System.out.println("Задание 2");
        List<String> list= Arrays.asList("зеленый", null, "красный");
        for (String s:list) {
            try {
                print(s);
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Ошибка обработана");
            }
        }
    }

    private static List<ArrayList<String>> putBookOnShelves(List<String> books) {

        books = books.stream()
                .sorted()
                .collect(Collectors.toList());

        List<ArrayList<String>> shelves = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        int num= 0;
        int shelfNum = 0;

        while (num < books.size()) {
            int perShelf = getBooksPerShelf(books.size() - num, shelves.size() - shelfNum);
            for (int i = 0; i < perShelf; i++) {
                shelves.get(shelfNum).add(books.get(num));
                num++;
            }
            shelfNum++;
        }
        return shelves;
    }

    private static int getBooksPerShelf(int books, int shelves) {
        int perShelf = books / shelves;
        if (perShelf * shelves < books)
            perShelf++;
        return perShelf;
    }

    private static void print(String s) {
        if (s == null) {
            throw new NullPointerException("Пожалуйста, введите данные");
        }
        System.out.println("Значение:" + s);
    }

}
