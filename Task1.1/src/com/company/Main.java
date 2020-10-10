package com.company;

import java.util.Scanner;

public class Main {

    public static boolean equality(SingleList p, SingleList q) {
        boolean flag;
        if (p.size() != q.size()) return false;
        else {
            for (int i = 0; i < p.size(); i++) {
                CoefWrap current = p.get(i);
                flag = false;
                for (int j = 0; j < q.size(); j++) {
                    if ((p.get(i).a == q.get(j).a) && (p.get(i).n == q.get(j).n)) flag = true;
                }
                if(!flag) return false;
            }
        }
        return true;
    }

    public static int meaning(SingleList p, int x) {
        int result = 0;
        int size = p.size();
        for (int i = 0; i < size; i++) {
            result += p.get(i).a * Math.pow(x, p.get(i).n);
        }
        return result;
    }

    public static SingleList add(SingleList p, SingleList q, SingleList r) {
        int seniorDegree = Math.max(q.seniorDegree, r.seniorDegree);
        for (int i = seniorDegree; i >= 0; i--) {
            p.add(q.getA(i) + r.getA(i), i);
        }

        return p;
    }

    static void printList(SingleList sl) {
        for (int i = 0; i < sl.size(); i++) {
            CoefWrap current = sl.get(i);
            if(i == sl.size()-1) {
                System.out.print(current.a + "x^" + current.n);
                break;
            }
            System.out.print(current.a + "x^" + current.n + " + ");
        }
    }

    public static void main(String[] args) {

        boolean flag = true;
        Scanner in = new Scanner(System.in);
        SingleList sl = new SingleList();

        do {
            System.out.println("1.Добавить \n2.Удалить \n3.Изменить \n4.Вывести на экран \n5.Equality " +
                    "\n6.Meaning \n7.Add \n8.Выход ");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("a = ");
                    int a = in.nextInt();
                    System.out.println("n = ");
                    int n = in.nextInt();
                    sl.add(a, n);
                    break;

                case 2:
                    printList(sl);
                    System.out.println("\n");
                    System.out.println("Номер: ");
                    int delete = in.nextInt();
                    sl.deleteIndex(delete);
                    break;

                case 3:
                    printList(sl);
                    System.out.println("\n");
                    System.out.println("Номер: ");
                    int change = in.nextInt();
                    System.out.println("a = ");
                    a = in.nextInt();
                    System.out.println("n = ");
                    n = in.nextInt();
                    sl.get(change).a = a;
                    sl.get(change).n = n;
                    break;

                case 4:
                    System.out.println("\n");
                    printList(sl);
                    System.out.println("\n");
                    break;

                case 5:
                    SingleList list1 = new SingleList();
                    SingleList list2 = new SingleList();
                    System.out.println("Размер первого многочлена: ");
                    int size1 = in.nextInt();
                    System.out.println("Размер второго многочлена: ");
                    int size2 = in.nextInt();
                    System.out.println("Введите первый многочлен: ");
                    for (int i = 0; i < size1; i++) {
                        System.out.println("a = ");
                        a = in.nextInt();
                        System.out.println("n = ");
                        n = in.nextInt();
                        list1.add(a,n);
                    }
                    System.out.println("Введите второй многочлен: ");
                    for (int i = 0; i < size2; i++) {
                        System.out.println("a = ");
                        a = in.nextInt();
                        System.out.println("n = ");
                        n = in.nextInt();
                        list2.add(a,n);
                    }
                    boolean result = equality(list1, list2);
                    if(result) System.out.println("Многочлены равны");
                    else System.out.println("Многочлены не равны");
                    break;

                case 6:
                    System.out.println("Введите x ");
                    int x = in.nextInt();
                    System.out.println("Введите длину списка ");
                    int l = in.nextInt();
                    SingleList list = new SingleList();
                    for (int i = 0; i < l; i++) {
                        System.out.println("a = ");
                        a = in.nextInt();
                        System.out.println("n = ");
                        n = in.nextInt();
                        list.add(a,n);
                    }
                    int resultMeaning = meaning(list, x);
                    System.out.println(resultMeaning);
                    break;

                case 7:
                    SingleList list3 = new SingleList();
                    SingleList list4 = new SingleList();
                    System.out.println("Размер первого многочлена: ");
                    size1 = in.nextInt();
                    System.out.println("Размер второго многочлена: ");
                    size2 = in.nextInt();
                    System.out.println("Введите первый многочлен: ");
                    for (int i = 0; i < size1; i++) {
                        System.out.println("a = ");
                        a = in.nextInt();
                        System.out.println("n = ");
                        n = in.nextInt();
                        list3.add(a,n);
                    }
                    System.out.println("Введите второй многочлен: ");
                    for (int i = 0; i < size2; i++) {
                        System.out.println("a = ");
                        a = in.nextInt();
                        System.out.println("n = ");
                        n = in.nextInt();
                        list4.add(a,n);
                    }
                    SingleList resultAdd = new SingleList();
                    add(resultAdd, list3, list4);
                    printList(resultAdd);
                    System.out.println("\n");
                    break;

                case 8:
                    flag = false;
                    break;
            }
        } while (flag);

        in.close();

    }
}
