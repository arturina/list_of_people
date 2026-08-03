package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true){
            System.out.println("\n -= Меню =- ");
            System.out.println("1. Добавить запись");
            System.out.println("2. Выход");
            if (!people.isEmpty()) {
                System.out.println("3. Показать список");
                System.out.println("4. Удалить запись");
            }
            System.out.print("Выберите пункт: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите гендер: ");
                    String gender = scanner.nextLine();
                    System.out.print("Поочерёдно введите год, месяц и день рождения.\nГод: ");
                    int year = scanner.nextInt();
                    System.out.print("Месяц: ");
                    int month = scanner.nextInt();
                    System.out.print("День: ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    LocalDate birthDate = LocalDate.of(year, month, day);
                    Person person = new Person(name, birthDate, gender);
                    people.add(person);
                    System.out.println("Запись добавлена.");
                    break;

                case "2":
                    System.out.println("Выход...");
                    return;

                case "3":
                    if (people.isEmpty()) {
                        System.out.println("Неверный пункт меню.");
                    } else {
                        System.out.println("Список людей:");
                        for (Person p : people) {
                            System.out.println("Имя: " + p.getName());
                            System.out.println("Гендер: " + p.getGender());
                            System.out.println("Возраст: " + p.getAge());
                            System.out.println("Дата рождения: " + p.getBirthDate());
                            System.out.println();
                        }
                    }
                    break;

                case "4":
                    if (people.isEmpty()) {
                        System.out.println("Неверный пункт меню.");
                    } else {
                        System.out.println("Записи в списке:");
                        for (int i = 0; i < people.size(); i++) {
                            Person p = people.get(i);
                            System.out.println((i + 1) + ". " + p.getName() + " " + p.getBirthDate());
                        }

                        System.out.print("\nВыберите номер записи для удаления: ");
                        int delIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (delIndex >= 1 && delIndex <= people.size()) {
                            Person removed = people.remove(delIndex - 1);
                            System.out.println("Удален: " + removed.getName());
                        } else {
                            System.out.println("Записи с таким номером не существует.");
                        }
                    }
                    break;

                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }
}