package com.ohgiraffers.mapping.section02.embedded;

import java.time.LocalDateTime;

public class BookRegistDTO {

    private String bookTitle;
    private String author;
    private String publisher;
    private LocalDateTime publishedDate;
    private int regularPrice;
    private double discountRate;

    public BookRegistDTO() {
    }

    public BookRegistDTO(String bookTitle, String author, String publisher, LocalDateTime publishedDate, int regularPrice, double discountRate) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "BookRegistDTO{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", regularPrice=" + regularPrice +
                ", discountRate=" + discountRate +
                '}';
    }
}
