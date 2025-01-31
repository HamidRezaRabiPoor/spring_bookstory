package org.example.domain;

import jakarta.persistence.*;
import org.example.constants.Category;

import java.util.Objects;

@Entity(name = "library")
@Table(name = "library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private int price;
    private int totalCount;
    private int sold;
    private Category category;
    public Book(){}
    public Book(int id, String title, String author, int price, int totalCount, int sold, Category category){
        this.id = id; this.author = author; this.title = title; this.price = price;
        this.totalCount = totalCount; this.category = category; this.sold = sold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return id == book.id && price == book.price && totalCount == book.totalCount &&
                sold == book.sold && Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) && category == book.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, totalCount, sold, category);
    }
}
