package com.domaindriven.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleWriterRepository extends JpaRepository<ArticleWriter, Long> {

    ArticleWriter findArticleWriterByArticleId(long articleId);
}
