package com.sbs.exam.miniProj2.controller;

import com.sbs.exam.miniProj2.service.ArticleService;
import com.sbs.exam.miniProj2.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class UsrArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/usr/article/doAdd")
    @ResponseBody
    public Article doAdd(String title, String body) {
        int id = articleService.writeArticle(title, body);

        Article article = articleService.getArticle(id);

        return article;
    }

    @RequestMapping("/usr/article/getArticles")
    @ResponseBody
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @RequestMapping("/usr/article/getArticle")
    @ResponseBody
    public Object getArticle(int id) {
        Article article = articleService.getArticle(id);

        if (article == null) {
            return id + "번 게시물이 존재하지 않습니다.";
        }
        return article;
    }

    @RequestMapping("/usr/article/doDelete")
    @ResponseBody
    public String doDelete(int id) {
        Article article = articleService.getArticle(id);
        if (article == null) {
            return id + "번 게시물이 존재하지 않습니다.";
        }
        articleService.deleteArticle(id);
        return id + "번 게시물을 삭제하였습니다.";
    }
}