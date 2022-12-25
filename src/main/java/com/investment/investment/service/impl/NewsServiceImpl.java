package com.investment.investment.service.impl;

import com.investment.investment.entity.NewsEntity;
import com.investment.investment.exception.BadRequestException;
import com.investment.investment.repository.NewsRepository;
import com.investment.investment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public NewsEntity addnews(NewsEntity newsEntity) {
        if (!StringUtils.hasText(newsEntity.getHeadline())){
            throw new BadRequestException("Judul News Harus Diisi");
        }
        if (!StringUtils.hasText(newsEntity.getDescription())){
            throw new BadRequestException("Description News Harus Diisi");
        }
        if (!StringUtils.hasText(newsEntity.getLinkImage())){
            throw new BadRequestException("Link Image Harus Diisi");
        }

        return newsRepository.save(newsEntity);
    }

    @Override
    public List<NewsEntity> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public void deleteNews(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}
