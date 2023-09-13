package org.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalog {
    public static void main(String[] args) {
        System.out.println("Welcome to your library catalog! Add 3 of your favourite books.");
        ArrayList<ArtAlbum> art_albums = new ArrayList<ArtAlbum>();
        ArrayList<Novel> novels = new ArrayList<Novel>();

        Scanner keyboard = new Scanner(System.in); //declaration before for loop for efficiency
        String name, kind;
        int nr_of_pages;
        int[] order = new int[4];

        for (int i = 1; i <= 3; ++i) {
            System.out.println("Name of the book " + i + ": ");
            name = keyboard.nextLine();

            System.out.println("Number of pages: ");
            nr_of_pages = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Kind (novel/art album): ");
            kind = keyboard.nextLine();

            if (kind.equals("novel")) {
                System.out.println("Type of the novel: ");
                String type = keyboard.nextLine();

                Novel novel = new Novel(type, nr_of_pages, name);
                novels.add(novel);
                order[i] = 1;
            } else {
                System.out.println("Paper quality: ");
                String paper_quality = keyboard.nextLine();

                ArtAlbum art_album = new ArtAlbum(paper_quality, nr_of_pages, name);
                art_albums.add(art_album);
                order[i] = 2;
            }
        }

        System.out.println("Type the name of the book you want to delete: ");
        int input = keyboard.nextInt();
        if (order[input] == 1) {
            if (input >= novels.size())
                novels.set(novels.size()-1, null);
            else
                novels.set(input, null);
        } else {
            if (input >= art_albums.size())
                art_albums.set(art_albums.size()-1, null);
            else
                art_albums.set(input, null);
        }
        order[input] = 0;

        int x = 0, j = 0;
        Novel currN = null;
        ArtAlbum currA = null;

        for (int i = 1; i <= 3; ++i)
            if (order[i] == 1) {
                currN = novels.get(x);
                System.out.println("Name of the book " + i + ": " + currN.getName());
                System.out.println("Number of pages: " + currN.getNrOfPage());
                System.out.println("Kind: novel");
                System.out.println("Type: " + currN.getType());
                ++x;
            } else if (order[i] == 2){
                currA = art_albums.get(j);
                System.out.println("Name of the book " + i + ": " + currA.getName());
                System.out.println("Number of pages: " + currA.getNrOfPage());
                System.out.println("Kind: art album");
                System.out.println("Type: " + currA.getPaper_quality());
                ++j;
            }
    }
}
