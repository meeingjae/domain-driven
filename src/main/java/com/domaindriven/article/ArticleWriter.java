package com.domaindriven.article;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import lombok.Getter;

@Getter
@Entity
@Immutable // 하이버네이트의 테이블 업데이트를 무시하도록 한다 (View 모델을 Update하고자 할 경우 Error 발생)
@Subselect(" " // hibernate의 문법을 그대로 따라야한다
           + " SELECT a.article_id as article_id, "
           + "        a.title as title, "
           + "        w.writer_id as writer_id, "
           + "        w.name as name "
           + "   FROM d_article a, "
           + "         d_writer w "
           + "  WHERE a.article_id = w.article_id")
@Synchronize({ "D_ARTICLE", "D_ATTRIBUTE_CONTENT", "D_WRITER" }) // Sync로 명시된 테이블에 변경 사항이 존재할 경우, 본 Entity 조회 시점 이전에 Sync 테이블의 변경사항을 먼저 반영한다
public class ArticleWriter {

    @Id
    private long articleId;

    private String title;

    private long writerId;

    private String name;

    protected ArticleWriter() {}

    public void setTitle(String title) {
        this.title = title;
    }
}
