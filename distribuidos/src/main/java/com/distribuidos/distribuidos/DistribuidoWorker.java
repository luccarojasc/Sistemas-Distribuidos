package com.distribuidos.distribuidos;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class DistribuidoWorker extends UnicastRemoteObject implements DistribuidoInterfaceRMI {

    protected DistribuidoWorker() throws RemoteException {
        super();
    }

    @Override
    public Map<String, List<String>> analyzeNumbers(int start, int end) throws RemoteException {
        List<String> perfects = new ArrayList<>();
        List<String> friendlies = new ArrayList<>();
        Map<Integer, Integer> sumDivisors = new HashMap<>();

        for (int i = start; i <= end; i++) {
            sumDivisors.put(i, sumOfDivisors(i));
        }

        Set<String> seenPairs = new HashSet<>();

        for (int i = start; i <= end; i++) {
            int sum = sumDivisors.get(i);

            if (sum == i && i != 1) {
                perfects.add(String.valueOf(i));
            }

            if (sum > i && sum <= end && sumDivisors.containsKey(sum)) {
                if (sumDivisors.get(sum) == i) {
                    String pair = i + " & " + sum;
                    String reverse = sum + " & " + i;
                    if (!seenPairs.contains(reverse)) {
                        friendlies.add(pair);
                        seenPairs.add(pair);
                    }
                }
            }
        }

        Map<String, List<String>> result = new HashMap<>();
        result.put("perfects", perfects);
        result.put("friendlies", friendlies);
        return result;
    }

    private int sumOfDivisors(int number) {
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) sum += i;
        }
        return sum;
    }
}
