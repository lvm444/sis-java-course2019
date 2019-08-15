package pro.sisit.courses.java.unit4;

import java.io.File;
import java.io.IOException;

public class ApplicationsMain {
    public static void main(String[] args) throws IOException {

        File file1 = new File("someFile.txt");

        File file2 = new File("/someFile.txt");

        File file3 = new File("./someFile.txt");

        System.out.println("Путь1 "+ file1.getCanonicalPath());

        System.out.println("Путь2 "+ file2.getCanonicalPath());

        System.out.println("Путь3 "+ file3.getCanonicalPath());
    }
}
