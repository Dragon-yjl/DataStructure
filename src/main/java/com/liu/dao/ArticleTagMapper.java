package com.liu.dao;

import com.liu.model.ArticleTag;

import java.util.List;

public interface ArticleTagMapper {
    int insertArticleTag(ArticleTag articleTag);

    List<ArticleTag> selectArticleTagByArticleId(Integer articleId);
}
