package pro.sisit.courses.java.unit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LectureSlideFolder {

    public static final String FOLDER = "C:/unit4Folder/";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    /* Каталоги length - не корректно */
    @Test
    public void slide5_isFolder() throws IOException {
        File inputFolder = new File(FOLDER + "/Folder1");

        assertTrue(inputFolder.exists());
        assertTrue(inputFolder.isDirectory());

        /// Не корректно
        System.out.println(inputFolder.length());
    }


    /* Каталоги list  */
    @Test
    public void slide5_list() throws IOException {
        File inputFolder = new File(FOLDER + "/Folder1");

        File[] files = inputFolder.listFiles();

        assert files != null;
        for (File itemFile :
                files) {
            System.out.println("Name "+itemFile.getName()+" isFile "+itemFile.isFile());
        }
    }

    /* Каталоги listFiles - c фильтром по расширению */
    @Test
    public void slide5_listfilter() throws IOException {
        File inputFolder = new File(FOLDER + "/Folder1");

        File[] fileList = inputFolder.listFiles(new EndsWithFileNameFilter(".log"));

        assert fileList != null;

        for (File fiileItem:fileList) {
            System.out.println("Name "+fiileItem.getName()+" isFile "+fiileItem.isFile());
        }
    }

    /* Каталоги mkdir - mkdirs if not exists*/
    @Test
    public void slide5_mkdir() throws IOException {
        File folder = tempFolder.newFolder("folder");

        System.out.println(folder.getCanonicalPath());

        assertTrue(folder.exists());

        File subFolder = new File(folder.getPath() + "/sub1/sub2");

        // проверяем что каталог не существует
        assertFalse(subFolder.exists());

        if (!subFolder.exists() && subFolder.mkdirs()) {
            System.out.println("Каталог " + subFolder.getCanonicalPath() + " создан");
        }
        //
        assertTrue(subFolder.getParentFile().exists());
    }


    /* Filter */
    private class EndsWithFileNameFilter implements FilenameFilter {
        private final String endwith;

        public EndsWithFileNameFilter(String endwith) {
            this.endwith = endwith;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(endwith);
        }
    }
}