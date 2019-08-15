package pro.sisit.courses.java.unit4.core;

public interface CSVAdapter<T extends CSVStorable> {
    T read(int index);

    int append(T itemObjet);
}
