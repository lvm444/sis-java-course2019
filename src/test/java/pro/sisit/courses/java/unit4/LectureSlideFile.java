package pro.sisit.courses.java.unit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LectureSlideFile {

    private static final String FOLDER = "C:/unit4Folder/";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    /* методы работы с файлом */
    @Test
    public void slide4_exists() throws IOException {
        File inputFile = new File(FOLDER + "inputAuthors.csv");

        assertTrue(inputFile.exists());
    }

    /* Пути getPath getAbsolutePath getCanonicalPath */
    @Test
    public void slide4_pathAbs() throws IOException {
        File inputFile = new File("./inputAuthors.csv");

        System.out.println("Путь "+inputFile.getPath());

        System.out.println("Абсолютный путь path "+inputFile.getAbsolutePath());

        System.out.println("Канонический путь path "+inputFile.getCanonicalPath());
    }

}