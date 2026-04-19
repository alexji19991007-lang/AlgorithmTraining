package Class18OOP1;

import java.io.FileReader;
import java.io.IOException;

// Checked Exceptions are checked at compile time.
//      - The compiler forces you to either:
//          - try-catch them, or
//          - declare them using throws
// Examples:
//      IOException
//      FileNotFoundException
//      SQLException
//      ClassNotFoundException
public class CheckedExceptionsExample {
    public void readFile1() throws IOException {
        FileReader fr = new FileReader("test.txt");
    }

    public void readFile2() {
        try {
            FileReader fr = new FileReader("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
