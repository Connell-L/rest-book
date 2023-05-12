package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
  public List<Book> getAllBooks() {
    return List.of(
        new Book(1, "Book 1", "A Author", 2020, "IT"),
        new Book(2, "Book 2", "B Author", 2021, "Sci-fi"),
        new Book(3, "Book 3", "C Author", 2022, "Fantasy"),
        new Book(4, "Book 4", "D Author", 2023, "IT"),
        new Book(5, "Book 5", "E Author", 2020, "Thriller")

    );
  }
  public Optional<Book> getBook(@PathParam("id") int id) {
    return getAllBooks().stream().filter(book -> book.id == id).findFirst();
  }
}
