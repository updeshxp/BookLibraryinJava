package io.github.updeshxp.project.RestSrv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person isBorrowedBy;
}
