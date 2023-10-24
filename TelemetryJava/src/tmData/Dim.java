package tmData;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class Dim {

    public final TreeMap<Integer, String> map = new TreeMap<>();

    public void run(String namef) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(namef));

        Integer i=1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(!line.isEmpty()) {
                map.put(i, line.trim());
            }
            i++;
        }
        scanner.close();
    }

    public void print() {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
