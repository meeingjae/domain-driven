package com.domaindriven.article;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class ArticleWriterTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    WriterRepository writerRepository;

    @Autowired
    ArticleWriterRepository articleWriterRepository;

    @Order(1)
    @Test
    void create() {
        articleRepository.save(new Article(1, "title", new ArticleContent("content", "contentType")));
        writerRepository.save(new Writer(1, "name", 1));
        ArticleWriter articleWriter = articleWriterRepository.findArticleWriterByArticleId(1); //articleId
        assertThat(articleWriter.getArticleId()).isEqualTo(1);
        assertThat(articleWriter.getWriterId()).isEqualTo(1);
        assertThat(articleWriter.getName()).isEqualTo("name");
        assertThat(articleWriter.getTitle()).isEqualTo("title");
    }

    @Order(2)
    @Test
    void update() {
        ArticleWriter articleWriter = articleWriterRepository.findArticleWriterByArticleId(1); //articleId
        articleWriter.setTitle("changed Title");
        ArticleWriter changedArticleWriter = articleWriterRepository.saveAndFlush(articleWriter);
        assertThat(changedArticleWriter.getArticleId()).isEqualTo(1);
        assertThat(changedArticleWriter.getWriterId()).isEqualTo(1);
        assertThat(changedArticleWriter.getName()).isEqualTo("name");
        assertThat(changedArticleWriter.getTitle()).isEqualTo("changed Title");
    }
}