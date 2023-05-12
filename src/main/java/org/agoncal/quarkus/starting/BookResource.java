package org.agoncal.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Book 1", "A Author", 2020, "IT"),
            new Book(2, "Book 2", "B Author", 2021, "Sci-fi"),
            new Book(3, "Book 3", "C Author", 2022, "Fantasy"),
            new Book(4, "Book 4", "D Author", 2023, "IT"),
            new Book(5, "Book 5", "E Author", 2020, "Thriller")

        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
