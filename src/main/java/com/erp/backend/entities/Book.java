package com.erp.backend.entities;

import com.erp.backend.entities.base.AuditableBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@SQLDelete(sql = "UPDATE book SET is_deleted = true WHERE bookId = ?")
@Where(clause = "is_deleted = false")
public class Book extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    @Column(length = 10000)
    private String bookDescribe;
    //    @Column(name = "img", length = 255, nullable = false)
//    private String img;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Category category;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Author author;

    private String image;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> listComment;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private User userCreate;


}
