<<<<<<< HEAD
package com.erp.backend.entities;

import com.erp.backend.entities.base.AuditableBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@SQLDelete(sql = "UPDATE book SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Book extends AuditableBase {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "describe1", length = 255, nullable = false)
    private String describe;
    @Column(name = "img", length = 255, nullable = false)
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
=======
package com.erp.backend.entities;


import com.erp.backend.entities.base.AuditableBase;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@SQLDelete(sql = "UPDATE book SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Book extends AuditableBase {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "describe", length = 255, nullable = false)
    private String describe;
    @Column(name = "img", length = 255, nullable = false)
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
>>>>>>> 71872cfc45d116b85eb2bc2b1a59cf716c98caad
