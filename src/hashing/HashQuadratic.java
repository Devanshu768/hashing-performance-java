package hashing;

class HashQuadratic {
    int[] table;
    int size;
    int totalProbes = 0;

    HashQuadratic(int size) {
        this.size = size;
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    void insert(int key) {
        int index = key % size;
        int i = 1;
        int probes = 0;

        while (table[index] != -1) {
            index = (key + i * i) % size;
            i++;
            probes++;
        }

        table[index] = key;
        totalProbes += probes;
    }
}
