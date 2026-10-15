package com.vuek0.calculator;


import java.util.ArrayList;
import java.util.Optional;

public class HistoryManager {
    private final ArrayList<String> operations = new ArrayList<>();

    public ArrayList<String> getAllOperations(){
        return new ArrayList<String>(operations);
    }

    public String getOperationByIndex(int index){
        return operations.get(index);
    }

    public Optional<String> getLastOperation() {
        if(this.getSize() == 0) return Optional.empty();
        return Optional.of(operations.getLast());
    }

    public int getSize() {
        return operations.size();
    }

    public void add(String operation) {
        if(operations.size() >= 10) operations.removeFirst();
        operations.add(operation);
    }

    public void clear() {
        operations.clear();
    }
}
