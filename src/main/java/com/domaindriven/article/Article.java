package com.domaindriven.article;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Entity
@Table(name = "D_ARTICLE")
@SecondaryTable(
        name = "D_ATTRIBUTE_CONTENT",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "articleId")
)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;

    private String title;

    @AttributeOverrides({
            @AttributeOverride(name = "content",
                    column = @Column(table = "D_ATTRIBUTE_CONTENT", name = "content")),
            @AttributeOverride(name = "contentType",
                    column = @Column(table = "D_ATTRIBUTE_CONTENT", name = "content_type"))
    })
    @Embedded
    private ArticleContent articleContent;

    protected Article() {}

    ;
}
