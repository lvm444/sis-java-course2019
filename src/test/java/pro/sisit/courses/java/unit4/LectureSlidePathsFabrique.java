package pro.sisit.courses.java.unit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LectureSlidePathsFabrique {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    /* Фабрика paths - экземпляр Path */
    @Test
    public void slide5_pathsget() throws IOException {

        Path someFileFirst = Paths.get("C:/temp1/temp2/someFile.txt");

        Path someFileSecond = Paths.get("C:/", "temp1", "temp2", "someFile.txt");

        assertEquals(someFileFirst.toString(),someFileSecond.toString());
    }

    /* Фабрика paths - slide5_pathsget - экземпляр Path ./.. */
    @Test
    public void slide5_pathroot() throws IOException {

        System.out.println(Paths.get(".").toFile().getCanonicalPath());

        System.out.println(Paths.get("./../..").toFile().getCanonicalPath());
    }
}