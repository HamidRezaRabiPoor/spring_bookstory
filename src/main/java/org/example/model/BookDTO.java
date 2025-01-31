package org.example.model;

import org.example.constants.Category;

import java.util.Objects;

public class BookDTO {
    private long id;
    private String title;
    private String author;
    private int price;
    private int totalCount;
    private int sold;
    private Category category;

    public BookDTO(){}
    public BookDTO(long id, String title, String author,
                   int price, int totalCount, int sold, Category category){
        this.id = id; this.title = title; this.author = author; this.price = price;
        this.totalCount = totalCount; this.sold = sold; this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        BookDTO bookDTO = (BookDTO) object;
        return id == bookDTO.id && price == bookDTO.price && totalCount == bookDTO.totalCount && sold == bookDTO.sold && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author) && category == bookDTO.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, totalCount, sold, category);
    }
}
