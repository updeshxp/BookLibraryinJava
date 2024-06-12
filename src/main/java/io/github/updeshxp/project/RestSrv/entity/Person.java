package io.github.updeshxp.project.RestSrv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String personName;
    private String personAddress;

    @OneToMany(targetEntity = Book.class, mappedBy = "bookId", fetch = FetchType.EAGER)
    private List<Book> booksList;

}
