<<<<<<< HEAD
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
@Table(name = "category")
@SQLDelete(sql = "UPDATE category SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Category extends AuditableBase {
    @Id
    @Column(nullable = false)
    private Long category_id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getCategory_id() {
        return category_id;
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
@Table(name = "category")
@SQLDelete(sql = "UPDATE category SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Category extends AuditableBase {
    @Id
    @Column(nullable = false)
    private Long category_id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getCategory_id() {
        return category_id;
    }
}
>>>>>>> 71872cfc45d116b85eb2bc2b1a59cf716c98caad
