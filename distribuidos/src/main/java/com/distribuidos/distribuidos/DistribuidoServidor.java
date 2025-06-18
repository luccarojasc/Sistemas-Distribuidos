package com.distribuidos.distribuidos;

import java.rmi.Naming;
import java.util.*;

public class DistribuidoServidor {
    public static void main(String[] args) {
        try {
            DistribuidoInterfaceRMI worker1 = (DistribuidoInterfaceRMI) Naming.lookup("rmi://localhost/Worker1");

            int start = 1;
            int end = 10000;
            int mid = (start + end) / 2;

            Map<String, List<String>> result1 = worker1.analyzeNumbers(start, mid);
            Map<String, List<String>> result2 = worker1.analyzeNumbers(mid + 1, end);

            List<String> allPerfects = new ArrayList<>();
            List<String> allFriendlies = new ArrayList<>();

            allPerfects.addAll(result1.get("perfects"));
            allPerfects.addAll(result2.get("perfects"));

            allFriendlies.addAll(result1.get("friendlies"));
            allFriendlies.addAll(result2.get("friendlies"));

            System.out.println("Numeros perfeitos encontrados:");
            allPerfects.forEach(System.out::println);

            System.out.println("\nPares de numeros amigaveis encontrados:");
            allFriendlies.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}