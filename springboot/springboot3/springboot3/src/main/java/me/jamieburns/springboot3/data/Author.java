package me.jamieburns.springboot3.data;

import java.util.Arrays;
import java.util.List;

public record Author( String id, String firstName, String lastName ) {

    private static List<Author> authors = Arrays.asList(
        new Author("author-1", "Joanne", "Rowling"),
        new Author("author-2", "John", "Bunyan"),
        new Author("author-3", "F. Scott", "Fitzgerald"),
        new Author("author-4", "Gabriel Garcia", "Marquez"),
        new Author("author-5", "Miguel de", "Cervantes")
    );

    public static Author findById(String id) {
        return authors.stream()
                      .filter(author -> author.id().equals(id))
                      .findFirst()
                      .orElse(null);
    }
}
