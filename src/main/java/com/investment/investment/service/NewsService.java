package com.investment.investment.service;

import com.investment.investment.entity.NewsEntity;

import java.util.List;

public interface NewsService {
    NewsEntity addnews(NewsEntity newsEntity);

    List<NewsEntity> getAll();

    void deleteNews(Long newsId);
}
