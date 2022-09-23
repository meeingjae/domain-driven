package com.domaindriven.article;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void articleSaveAndFind() {
        articleRepository.saveAll(
                Arrays.asList(
                        Article.builder()
                               .title("title1")
                               .articleContent(new ArticleContent("content1", "type1"))
                               .build(),
                        Article.builder()
                               .title("title2")
                               .articleContent(new ArticleContent("content2", "type2"))
                               .build()));

        List<Article> articles = articleRepository.findAll();

        assertThat(articles).hasSize(2);
    }
}
