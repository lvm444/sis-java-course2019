package pro.sisit.courses.java.unit4;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.sun.xml.internal.ws.util.ASCIIUtility;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LectureSlideInputOutputStream {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    public static final String FOLDER = "C:/unit4Folder/";


    /* читаем файл read() byte */
    @Test
    public void slide_read() throws IOException {

        File inputAuthorsFile =
                Paths.get(FOLDER)
                        .resolve("inputAuthors.csv").toFile();

        FileInputStream fis;
        fis = new FileInputStream(inputAuthorsFile);

        int read = 0;
        while ((read = fis.read()) != -1) {
            System.out.print((char) read);
        }

        fis.close();
    }


    /* копируем бинарный файл */
    @Test
    public void slide_readCopy() throws IOException {

        File copyFile = tempFolder.
                            newFile("copyAuthors.csv");

        File inputAuthorsFile =
                    Paths.get(FOLDER)
                            .resolve("inputAuthors.csv").toFile();

        FileInputStream fis;
        fis = new FileInputStream(inputAuthorsFile);

        FileOutputStream fos = new FileOutputStream(copyFile);

        int read = 0;
        byte[] buffer = new byte[4096];
        while ((read = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, read);
        }

        fos.close();

        assertTrue(copyFile.exists());
    }

}