package com.onevizion.booksonevizion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String title;
    private String author;
    private String description;

    public Book() { }


    public static class Builder {
        private Integer id;
        private String title;
        private String author;
        private String description;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

    private Book(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.title = builder.title;
        this.author = builder.author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
