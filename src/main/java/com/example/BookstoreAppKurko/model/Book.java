/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BookstoreAppKurko.model;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@Entity
public class Book {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private int price;
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
    
     public Book(String title, String author, int year, String ISBN, int price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = ISBN;
        this.price = price;
    }

    public Book() {
    }

    
    
    
}
