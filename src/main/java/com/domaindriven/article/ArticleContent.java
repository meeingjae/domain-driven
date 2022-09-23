package com.domaindriven.article;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class ArticleContent {

    private String content;
    private String contentType;

    protected ArticleContent() {};
}
