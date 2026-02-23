package com.unicesumar.demo.Controller;

import com.unicesumar.demo.Entity.Books;
import com.unicesumar.demo.Service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books") //localhost:8080/books
public class BooksController {

    private final BooksService booksService;

    public BooksController (BooksService booksService){
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> buscarTodos(){
        return booksService.buscarTodos();
    }

    @GetMapping("{id}")
    public Books buscarPorId(@PathVariable Long id){
        return booksService.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletarBook(@PathVariable Long id){
        booksService.deletarBook(id);
    }

    @PostMapping
    public Books adicionarBook(@RequestBody Books books){
        return booksService.adicionarBook(books);
    }

    @PutMapping("{id}")
    public Books atualizarBook(@PathVariable Long id, @RequestBody Books bookAtualizado){
        return booksService.atualizarBook(id, bookAtualizado);
    }
}
