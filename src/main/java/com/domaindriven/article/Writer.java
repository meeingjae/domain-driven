package com.domaindriven.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Table(name = "D_WRITER")
@Entity
@AllArgsConstructor
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long writerId;

    @Column(name = "name")
    private String name;

    @Column(name = "article_id")
    private long articleId;

    protected Writer() {}
}
