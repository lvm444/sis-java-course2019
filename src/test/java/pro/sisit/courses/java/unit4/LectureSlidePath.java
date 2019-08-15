package pro.sisit.courses.java.unit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LectureSlidePath {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    /* Каталоги paths - slide5_mkdir - правильно */
    @Test
    public void slide5_pathResolve() throws IOException {
        File folder = tempFolder.newFolder("folder");

        //File subFolder = new File(folder.getPath()+"/sub1/sub2");

        Path subPath = folder.toPath().resolve("sub1").resolve("sub2");
        File subFolder = subPath.toFile();

        // проверяем что каталог не существует
        assertFalse(subFolder.exists());

        // создаем цепочку каталогов
        assertTrue(subFolder.mkdirs());

        System.out.println(subFolder.getCanonicalPath());

        assertTrue(subFolder.exists());


    }
}