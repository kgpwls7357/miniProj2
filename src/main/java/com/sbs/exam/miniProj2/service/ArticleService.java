package com.sbs.exam.miniProj2.service;

import com.sbs.exam.miniProj2.repository.ArticleRepository;
import com.sbs.exam.miniProj2.vo.Article;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public int writeArticle(String title, String body) {
        articleRepository.writeArticle(title, body);
        return articleRepository.getLastInsertId();
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