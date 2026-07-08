package memroyManagement;

import java.util.ArrayList;
import java.util.List;

public class FixHeapSize {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int count = 0;

        // 1 int = 4 bytes.
        // 262,144 ints = exactly 1,048,576 bytes (1 MB)
        int oneMegaByteOfInts = 262144;

        try {
            while (true) {
                // This allocates a real 1 MB primitive array block
                list.add(new int[oneMegaByteOfInts]);
                count++;
                System.out.println("Allocated block: " + count);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\nCrashed successfully!");
            System.out.println("Total blocks allocated: " + count);
        }
    }
}


/*
    -Xms2m for minimum heap space jvm needs to run the program.
    -Xmx4m from maximum heap space can jvm needs.
 */