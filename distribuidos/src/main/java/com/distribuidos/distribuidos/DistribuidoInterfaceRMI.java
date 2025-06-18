package com.distribuidos.distribuidos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface DistribuidoInterfaceRMI extends Remote {
    Map<String, List<String>> analyzeNumbers(int start, int end) throws RemoteException;
}
