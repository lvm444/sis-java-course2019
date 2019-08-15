package pro.sisit.courses.java.unit4;

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
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class LectureSlideReaderWriter {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    public static final String FOLDER = "C:/unit4Folder/";


    /* читаем текстовый файл line by line. BufferedReader wrap InputStreamReader adopt FileInputStream */
    @Test
    public void slide_read() throws IOException {
        File file =
                Paths.get(FOLDER)
                        .resolve("inputAuthors.csv").toFile();

        FileInputStream fis = new FileInputStream(file);

        InputStreamReader reader = new InputStreamReader(fis,StandardCharsets.UTF_8);

        BufferedReader lineReader = new BufferedReader(reader);

        String readLine = null;
        while ((readLine = lineReader.readLine()) != null)
        {
            System.out.println(readLine);
        }

        lineReader.close();
    }

    /* пишем в текстовый файл */
    @Test
    public void slide_scanner() throws IOException {

        Path file =
                Paths.get(FOLDER)
                        .resolve("inputAuthors.csv");
        Scanner scanner = new Scanner(file, String.valueOf(StandardCharsets.UTF_8));

        scanner.useDelimiter("\\n");
        while (scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }

    /* пишем в текстовый файл BufferedWriter wrap OutputStreamWriter adapt FileOutputStream*/
    @Test
    public void slide_write() throws IOException {
        File writeFile = tempFolder.newFile("somedata.txt");

        FileOutputStream fos = new FileOutputStream(writeFile);

        OutputStreamWriter outputStreamWriter
                = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        BufferedWriter buffWriter = new BufferedWriter(outputStreamWriter);

        List<String> stringArray = Arrays.asList("Строка номер 1","Строка номер 2","Строка номер 3");

        for (String itemString :
                stringArray) {
            buffWriter.write(itemString);
            buffWriter.newLine();
        }
        buffWriter.close();
    }

    /* пишем в текстовый файл BufferedWriter and Files.newBufferedWriter */
    @Test
    public void slide_print_writer() throws IOException {

        File writeFile = tempFolder.newFile("somedata.txt");

        BufferedWriter buffWriter = Files.newBufferedWriter(writeFile.toPath(),
                                            StandardCharsets.UTF_8,StandardOpenOption.APPEND);

        List<String> stringArray = Arrays.asList("Строка номер 1","Строка номер 2","Строка номер 3");

        for (String itemString :
                stringArray) {
            buffWriter.write(itemString);
            buffWriter.newLine();
        }
        buffWriter.close();
    }
}