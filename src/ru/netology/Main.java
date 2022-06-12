package ru.netology;

public class Main {
    public static void main(String[] args) {
        try {
            Person mom = new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();

            Person son = mom.newChildBuilder()
                    .setName("Антошка")
                    .build();

            System.out.println("У " + mom + " есть сын, " + son);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
