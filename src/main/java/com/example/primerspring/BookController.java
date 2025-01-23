package com.example.primerspring;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = {"http://localhost:4200/"})

public class BookController {

    //Lista de todos los libros disponibles
    List<Book> books = List.of(
            new Book(1L, "book1", "Antonio"),
            new Book(2L, "book2", "Federico"),
            new Book(3L, "book3", "Alfredo"),
            new Book(4L, "Mi Libro :)", "Juanjo")
    );

    //Metodo findAll()
    @GetMapping
    public List<Book> findAll(){
        System.out.println("findAll");
        return books;
    }

    //Metodo findById()
    @GetMapping("/{id}")
    public Stream<Book> findById(@PathVariable long id) {
        System.out.println("findById " + id);

        // Buscar el libro por ID (mediante stream se procesan los datos
        // de la lista de libros y luego con filter filtramos por id
        return books.stream().filter(book -> book.getId() == id);
    }

    @GetMapping("/Autores")
    public List<Book> findAutores(){
        System.out.println("findAutores");
        return books;
    }

}
