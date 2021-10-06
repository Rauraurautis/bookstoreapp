/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BookstoreAppKurko.web;

import com.example.BookstoreAppKurko.model.Book;
import com.example.BookstoreAppKurko.model.BookRepository;
import com.example.BookstoreAppKurko.model.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @GetMapping("/addbook")
    public String getIndex(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        if (book.getTitle().isEmpty()) {
            return "redirect:/booklist";
        }
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", cRepository.findAll());
        return "editbook";
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Book> allBooksRest() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public Optional<Book> getBookByIdRest(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

}
