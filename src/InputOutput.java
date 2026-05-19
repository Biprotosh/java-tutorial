import java.io.*;

public class InputOutput {
    public static void main(String[] args) throws IOException {
        int x = System.in.read();

        System.out.println(x);
        System.out.println((char) x);

        int y = System.in.read();
        System.out.println((char) y);

        // BufferedReader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String name = br.readLine();
        System.out.println(name);
    }
}

/**
 * 1. Write Biprotosh
 * 2. OS buffer (ASCII of Biprotosh)
 * 3. System.in (InputStream) receives bytes
 * 4. InputStreamReader converts stream of bytes to stream of characters
 *                  ('B', 'i', 'p', 'r', 'o', 't', 'o', 's', 'h')
 * 5. BufferedReader stores the characters in its own buffer
 * 6. And using readLine() it will read the line and store it to name variable
 */
