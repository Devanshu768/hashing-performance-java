package hashing;


import java.util.Random;

class HashLinear {
    int[] table;
    int size;
    int totalProbes = 0;

    HashLinear(int size) {
        this.size = size;
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    void insert(int key) {
        int index = key % size;
        int probes = 0;

        while (table[index] != -1) {
            index = (index + 1) % size;
            probes++;
        }

        table[index] = key;
        totalProbes += probes;
    }
}

