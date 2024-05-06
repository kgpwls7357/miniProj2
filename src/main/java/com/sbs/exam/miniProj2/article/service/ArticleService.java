package com.sbs.exam.miniProj2.article.service;

import com.sbs.exam.miniProj2.article.repository.ArticleRepository;
import com.sbs.exam.miniProj2.article.vo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        articleRepository.makeTestData();
    }

    public Article writeArticle(String title, String body) {
        return articleRepository.writeArticle(title, body);
    }

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public Article getArticle(int id) {
        return articleRepository.getArticle(id);
    }

    public void deleteArticle(int id) {
        articleRepository.deleteArticle(id);
    }

    public void modifyArticle(int id, String title, String body) {
        articleRepository.modifyArticle(id, title, body);
    }
}