package com.unicesumar.demo.Service;


import com.unicesumar.demo.Entity.Books;
import com.unicesumar.demo.Repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public Books adicionarBook (Books books){
        return booksRepository.save(books);
    }

    public List<Books> buscarTodos(){
        return booksRepository.findAll();
    }

    public Optional<Books> buscarPorId(Long id){
        return booksRepository.findById(id);
    }

    public void deletarBook(Long id){
        booksRepository.deleteById(id);
    }

    public Books atualizarBook(Long id, Books bookAtualizado){
        Books books = booksRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado com id " + id));

        books.setNome(bookAtualizado.getNome());
        books.setAutor(bookAtualizado.getAutor());
        books.setAno(bookAtualizado.getAno());
        books.setPreco(bookAtualizado.getPreco());

        return booksRepository.save(books);
    }
}
