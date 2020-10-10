package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RingList rl = new RingList();

        Scanner in = new Scanner(System.in);

        System.out.println("Введите число детей");
        final int N = in.nextInt();
        System.out.println("Удаляем каждого к-ого. к = ");
        final int k = in.nextInt();

        for (int i = 1; i <= N; i++) {
            rl.add(i);
        }

        int[] remainArr = new int[N];
        for (int i = 0; i < N; i++) {
            remainArr[i] = i+1;
        }

        int remaining = N;
        int counter = 1;

        Iterator iter = new Iterator(rl);
        iter.reset();

        while(remaining != 1) {
            if(counter % k == 0) {
                for(int tmp : remainArr) {
                    if(tmp != 0) System.out.print(tmp + " ");
                }
                System.out.println("\n");
                int toDelete = iter.getCurrent().num;
                iter.deleteCurrent();
                remaining--;
                for (int i = 0; i < remainArr.length; i++) {
                    if(remainArr[i] == toDelete) remainArr[i] = 0;
                }
            }
            counter++;
            iter.nextNode();
        }
        for(int tmp : remainArr) {
            if(tmp != 0) System.out.print(tmp + " ");
        }
        System.out.println("\n");
    }
}
