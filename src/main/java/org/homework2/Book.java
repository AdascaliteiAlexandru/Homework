package org.homework2;

public class Book {
    private String name;
    private int nr_of_pages = 0;
    public void setName(String name) {
        this.name = name;
    }
    public void setNrOfPage(int nr_of_pages) {
        this.nr_of_pages = nr_of_pages;
    }

    public String getName() {
        return this.name;
    }

    public int getNrOfPage() {
        return this.nr_of_pages;
    }
}
