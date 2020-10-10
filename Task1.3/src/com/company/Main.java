package com.company;

import java.util.Scanner;

public class Main {

    static void add(SinglePhoneList list, int num, String name) {
        Iterator iter = new Iterator(list);

        if (list.isEmpty()) {
            list.add(num, name);
            return;
        }

        if (name.compareTo(list.getFirst().item.name) <= 0) {
            list.insertFirst(num, name);
            return;
        }
        if (name.compareTo(list.getLast().item.name) >= 0) {
            list.insertLast(num, name);
            return;
        }

        while (iter.getCurrent() != null) {
            if (name.compareTo(iter.getCurrent().item.name) < 0) {
                iter.insertBefore(num, name);
                return;
            }
            iter.nextNode();
        }
    }

    static String getLastNameByNumber(int number, SinglePhoneList list) {
        String lastName;

        Iterator iter = new Iterator(list);

        while (iter.getCurrent() != null) {
            if (iter.getCurrent().item.number == number) {
                String name = iter.getCurrent().item.name;
                String[] tmp = name.split(" ", 2);
                lastName = tmp[0];
                return lastName;
            }
            iter.nextNode();
        }

        return null;
    }

    static SinglePhoneList getPhoneListByLastName(String lastName, SinglePhoneList list) {
        SinglePhoneList phoneList = new SinglePhoneList();
        Iterator iter = new Iterator(list);

        while (iter.getCurrent() != null) {
            String[] tmp = iter.getCurrent().item.name.split(" ");
            String currentLastName = tmp[0];
            if(currentLastName.equals(lastName)) phoneList.add(iter.getCurrent().item.number, iter.getCurrent().item.name);
            iter.nextNode();
        }
        return phoneList;
    }

    static void printList(SinglePhoneList list) {
        Iterator iter = new Iterator(list);

        while (iter.getCurrent() != null) {
            System.out.println(iter.getCurrent().item.name + ", " + iter.getCurrent().item.number);
            iter.nextNode();
        }
    }

    public static void main(String[] args) {
        SinglePhoneList list = new SinglePhoneList();

        boolean flag = true;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("1.Добавить \n2.Удалить \n3.Вывести на экран \n4.Фамилия по номеру телефона " +
                    "\n5.Список номеров по фамилии \n6.Выход \n");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    in.nextLine();
                    System.out.println("ФИО ");
                    String name = in.nextLine();
                    System.out.println("Номер ");
                    int number = in.nextInt();
                    add(list, number, name);
                    break;

                case 2:
                    printList(list);
                    System.out.println("\n");
                    System.out.println("Номер: ");
                    int delete = in.nextInt();
                    list.deleteIndex(delete);
                    break;

                case 3:
                    System.out.println("\n");
                    printList(list);
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("Номер: ");
                    number = in.nextInt();
                    String lastName = getLastNameByNumber(number, list);
                    if (lastName != null)
                        System.out.println(lastName);
                    else System.out.println("Совпадения не найдены");
                    break;

                case 5:
                    in.nextLine();
                    System.out.println("Фамилия ");
                    name = in.nextLine();
                    printList(getPhoneListByLastName(name, list));
                    break;

                case 6:
                    flag = false;
                    break;
            }
        } while (flag);

        in.close();

    }
}
