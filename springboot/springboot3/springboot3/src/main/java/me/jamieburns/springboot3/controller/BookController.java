package me.jamieburns.springboot3.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import me.jamieburns.springboot3.data.Author;
import me.jamieburns.springboot3.data.Book;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById( @Argument String id) {
        return Book.findById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.findById(book.authorId());
    }
}
