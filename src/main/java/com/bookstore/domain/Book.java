package com.bookstore.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 2356345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, updatable = false)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private int numberOfPages;
    private String format;
    private String isbn;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active = true;

    @Column(columnDefinition="text")
    private String description;
    private int inStockNumber;

    @Transient
    private MultipartFile bookImage;

    public Book() {
    }
}
