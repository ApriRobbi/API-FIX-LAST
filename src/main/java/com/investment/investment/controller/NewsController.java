package com.investment.investment.controller;

import com.investment.investment.entity.NewsEntity;
import com.investment.investment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("/news")
    public NewsEntity addnews(@RequestBody NewsEntity newsEntity){
        return newsService.addnews(newsEntity);
    }

    @GetMapping("/news")
    public List<NewsEntity> findAll(){
        return newsService.getAll();
    }

    @DeleteMapping("/news/{newsId}")
    public void delete(@PathVariable("newsId") Long newsId){
        newsService.deleteNews(newsId);
    }
}
