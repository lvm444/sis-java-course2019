package pro.sisit.courses.java.unit4.domain;

import pro.sisit.courses.java.unit4.core.CSVStorable;

public class Author implements CSVStorable {
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    private String name;
    private String birthPlace;

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
}
