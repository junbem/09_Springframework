package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="tbl_book")
public class Book {
    @Id
    @Column(name="book_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookNo;

    @Column(name="book_title")
    private String bookTitle;

    @Column(name="author")
    private String author;

    @Column(name="publisher")
    private String publisher;

    @Column(name="published_date")
    private LocalDateTime publishedDate;

    @Embedded
    private Price price;

    public Book() {}

    public Book(String bookTitle, String author, String publisher, LocalDateTime publishedDate, Price price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price +
                '}';
    }
}
