package hashing;

import java.util.Random;

public class MainHash {
    public static void main(String[] args) {

        int size = 20011;   // prime number (important for hashing)
        int n = 10000;      // number of elements

        HashLinear linear = new HashLinear(size);
        HashQuadratic quadratic = new HashQuadratic(size);

        Random rand = new Random();

        // 🔹 Insert random values
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(100000);

            linear.insert(key);
            quadratic.insert(key);
        }

        // 🔹 Load Factor
        double loadFactor = (double) n / size;

        // 🔹 Results
        System.out.println("Total Insertions: " + n);
        System.out.println("Load Factor: " + loadFactor);

        System.out.println("\nLinear Probing:");
        System.out.println("Total Probes: " + linear.totalProbes);
        System.out.println("Average Probes: " + (double) linear.totalProbes / n);

        System.out.println("\nQuadratic Probing:");
        System.out.println("Total Probes: " + quadratic.totalProbes);
        System.out.println("Average Probes: " + (double) quadratic.totalProbes / n);

        // 🔥 Comparison Insight
        if (linear.totalProbes > quadratic.totalProbes) {
            System.out.println("\nQuadratic probing performed better.");
        } else if (linear.totalProbes < quadratic.totalProbes) {
            System.out.println("\nLinear probing performed better.");
        } else {
            System.out.println("\nBoth performed equally.");
        }
    }
}
