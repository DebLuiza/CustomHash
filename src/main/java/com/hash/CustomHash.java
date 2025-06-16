package com.hash;

public class CustomHash {

    static class Par {
        // value: valor do array original
        // posic: posição (índice) desse valor no array
        int posic;
        int value;

        Par(int posic, int value) {
            this.posic = posic;
            this.value = value;
        }
    }

    Par[] table;

    public CustomHash(int size) {
        table = new Par[size];
    }

    private int hash(int value) {
        return Math.abs(value) % table.length; // evita índice negativo
    }

    public void put(int value, int posic) {
        int index = hash(value);
        while (table[index] != null && table[index].value != value) {
            index = (index + 1) % table.length;
        }
        table[index] = new Par(posic, value);
    }

    public boolean containsKey(int value) {
        int index = hash(value);
        int start = index;
        while (table[index] != null) {
            if (table[index].value == value)
                return true;
            index = (index + 1) % table.length;
            if (index == start)
                break;
        }
        return false;
    }

    public int getPosic(int value) {
        int index = hash(value);
        int start = index;
        while (table[index] != null) {
            if (table[index].value == value)
                return table[index].posic;
            index = (index + 1) % table.length;
            if (index == start)
                break;
        }
        throw new IllegalArgumentException("Key not found: " + value);
    }

}