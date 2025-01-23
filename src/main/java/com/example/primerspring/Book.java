package com.example.primerspring;

public record Book(Long id, String title, String author) {

    public long getId() {
        return id;
    }
}
