package io.github.updeshxp.project.RestSrv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookCode;
    private String bookPublisher;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person isBorrowedBy;
}
