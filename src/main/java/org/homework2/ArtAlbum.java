package org.homework2;

public class ArtAlbum extends Book{
    private String paper_quality;

    ArtAlbum(String paper_quality, int nr_of_pages, String name) {
        setPaper_quality(paper_quality);
        setName(name);
        setNrOfPage(nr_of_pages);
    }
    public void setPaper_quality(String paper_quality) {
        this.paper_quality = paper_quality;
    }

    public String getPaper_quality() {
        return this.paper_quality;
    }
}
