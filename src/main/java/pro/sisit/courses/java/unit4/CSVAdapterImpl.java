package pro.sisit.courses.java.unit4;

import pro.sisit.courses.java.unit4.core.CSVAdapter;
import pro.sisit.courses.java.unit4.core.CSVStorable;
import pro.sisit.courses.java.unit4.domain.Author;

import java.io.*;

public class CSVAdapterImpl<T extends CSVStorable> implements CSVAdapter<T> {
    private final Class<? extends CSVStorable> type;
    private final Reader reader;
    private final BufferedWriter writer;

    public CSVAdapterImpl(Class<? extends CSVStorable> entityType, Reader reader, Writer writer) {
        this.type =  entityType;
        this.reader = new BufferedReader(reader);
        this.writer = new BufferedWriter(writer);
    }

    @SuppressWarnings("unchecked")
    public T read(int index) {
        Author author = new Author();

        return (T) type.cast(author);
    }

    @Override
    public int append(T itemObjet) {
        return 0;
    }
}
