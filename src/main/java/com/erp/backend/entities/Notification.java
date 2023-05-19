package com.erp.backend.entities;

import com.erp.backend.entities.base.AuditableBase;
import com.erp.backend.enums.ReadStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notify")
@SQLDelete(sql = "UPDATE notification SET is_deleted = true WHERE category_id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Notification extends AuditableBase {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Book book;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userCreate;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private User userTarget;
    @Enumerated(EnumType.STRING)
    private ReadStatus isRead;

}
