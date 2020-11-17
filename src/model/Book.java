/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Book {
    
    private int id;
    private String nome;
    private String author;
    private String publisher;
    private String isbn;
    private Double preco;

    public Book(int id, String nome, String author, String publisher, String isbn, Double preco) {
        this.id = id;
        this.nome = nome;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.preco = preco;
    }

    public Book() {
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPreco() {
        return preco;
    }

    public void setDisponibilidade(Double preco) {
        this.preco = preco;
    }    

//    public void setNome(String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void setPublisher(String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void setPreco(Double valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
