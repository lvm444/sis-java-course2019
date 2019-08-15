package pro.sisit.courses.java.unit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import pro.sisit.courses.java.unit4.core.CSVAdapter;
import pro.sisit.courses.java.unit4.domain.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVObjectReaderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        File inputFile = new File("./resources/inputAuthors.csv");

        FileReader fileReader = new FileReader(inputFile);

        FileWriter fileWriter = new FileWriter(tempFolder.newFile());

        CSVAdapter<Author> authorCsvAdapter = new CSVAdapterImpl<Author>(Author.class,fileReader,fileWriter);

        Author author = authorCsvAdapter.read(0);
        assertEquals("Лев Николаевич Толстой",author.getName());
        assertEquals("Ясная Поляна",author.getBirthPlace());

        Author authorNew = new Author();
        authorNew.setName("Некоторый Автор");
        authorNew.setName("Некоторый Город");

        int rowIndex = authorCsvAdapter.append(authorNew);

        Author authorNewOpened = authorCsvAdapter.read(0);

        assertEquals("Лев Николаевич Толстой",author.getName());
        assertEquals("Ясная Поляна",author.getBirthPlace());
    }

}