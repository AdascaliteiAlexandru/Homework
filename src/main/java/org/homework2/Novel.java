package org.homework2;

public class Novel extends Book {
    private String type;

    Novel(String type, int nr_of_pages, String name) {
        setType(type);
        setName(name);
        setNrOfPage(nr_of_pages);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
