/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "tb_publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 3783093145423408126L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_publisher")
    private Long idPublisher;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "adress")
    private String address;
    
    @OneToOne(mappedBy="publisher")
    private Book bookPublished;

    public Long getId() {
        return idPublisher;
    }

    public void setId(Long id) {
        this.idPublisher = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book getBookPublished() {
        return bookPublished;
    }

    public void setBookPublished(Book bookPublished) {
        this.bookPublished = bookPublished;
    }

    public Publisher(Long id, String name, String address, Book bookPublished) {
        this.idPublisher = id;
        this.name = name;
        this.address = address;
        this.bookPublished = bookPublished;
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher() {
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idPublisher);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publisher other = (Publisher) obj;
        if (!Objects.equals(this.idPublisher, other.idPublisher)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publisher{" + "id=" + idPublisher + ", name=" + name + ", address=" + address + ", bookPublished=" + bookPublished + '}';
    }    
}