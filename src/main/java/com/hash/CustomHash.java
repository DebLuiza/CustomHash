package com.hash;

public class CustomHash {

    static final Par DELETED = new Par(-1, -1);

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

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                System.out.println(i + ": null");
            } else if (table[i] == DELETED) {
                System.out.println(i + ": <DELETED>");
            } else {
                System.out.println(i + ": (" + table[i].value + ", pos=" + table[i].posic + ")");
            }
        }
    }

}