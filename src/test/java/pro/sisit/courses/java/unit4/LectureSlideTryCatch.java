package pro.sisit.courses.java.unit4;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LectureSlideTryCatch {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    public static final String FOLDER = "C:/unit4Folder/";


    /* ByteArrayInputStream throw IllegalArgumentException -> finally */
    @Test
    public void slide_catch_finaly() throws IOException {

        ByteArrayInputStream bais = null;
        try
        {
            byte[] bytes = new byte[100];
            bais = new ByteArrayInputStream(bytes);

            throw new IllegalArgumentException();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Исключение обработано");
        }
        finally {
            System.out.println("Finaly execute");
            if(bais!=null) {
                bais.close();
                System.out.println("Stream closed");
            }
        }

    }

}