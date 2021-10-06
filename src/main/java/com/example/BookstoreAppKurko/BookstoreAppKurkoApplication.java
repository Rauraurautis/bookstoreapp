package com.example.BookstoreAppKurko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.BookstoreAppKurko.model.Book;
import com.example.BookstoreAppKurko.model.BookRepository;
import com.example.BookstoreAppKurko.model.Category;
import com.example.BookstoreAppKurko.model.CategoryRepository;
import static java.lang.Math.log;
import static java.lang.StrictMath.log;
import static java.rmi.server.LogStream.log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreAppKurkoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreAppKurkoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CategoryRepository repository, BookRepository bRepository) {
        return (args) -> {
            repository.save(new Category("Fantasy"));
            repository.save(new Category("Horror"));
            repository.save(new Category("Sci-fi"));
            repository.save(new Category("Drama"));
            bRepository.save(new Book("Test book", "Test Author", 1995, "ISBN", 50));
        };

    }
}
