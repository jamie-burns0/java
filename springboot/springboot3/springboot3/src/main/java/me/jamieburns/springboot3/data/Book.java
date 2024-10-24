package me.jamieburns.springboot3.data;

import java.util.Arrays;
import java.util.List;

public record Book( String id, String name, int pageCount, String authorId ) {

    private static List<Book> books = Arrays.asList(
        new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
        new Book("book-2", "Pilgrim's Progress", 336, "author-2"),
        new Book("book-3", "The Great Gatsby", 180, "author-3"),
        new Book("book-4", "One Hundred Years of Solitude", 417, "author-4"),
        new Book("book-5", "Don Quixote", 863, "author-5")
    );

    public static Book findById(String id) {
        return books.stream()
                    .filter(book -> book.id().equals(id))
                    .findFirst()
                    .orElse(null);
    }
}
