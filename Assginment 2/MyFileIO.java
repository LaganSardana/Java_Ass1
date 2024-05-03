import java.util.Scanner;
import java.util.Formatter;

public interface MyFileIO {
    void inputData(Scanner scanner);

    void outputData(Formatter formatter);

    String toString();

}