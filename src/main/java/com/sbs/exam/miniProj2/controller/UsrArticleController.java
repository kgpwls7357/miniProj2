package com.sbs.exam.miniProj2.controller;

import com.sbs.exam.miniProj2.service.ArticleService;
import com.sbs.exam.miniProj2.util.Ut;
import com.sbs.exam.miniProj2.vo.Article;
import com.sbs.exam.miniProj2.vo.ResultData;
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
    public ResultData doAdd(String title, String body) {
        if(Ut.empty(title)) {
            return ResultData.from("F-1","title(을)를 입력해주세요.");
        }
        if(Ut.empty(body)) {
            return ResultData.from("F-2","body(을)를 입력해주세요.");
        }

        ResultData writeArticleRd = articleService.writeArticle(title, body);

        int id = (int)writeArticleRd.getData1();
        Article article = articleService.getArticle(id);

        return ResultData.from(writeArticleRd.getResultCode(),writeArticleRd.getMsg(), article);
    }

    @RequestMapping("/usr/article/getArticles")
    @ResponseBody
    public ResultData getArticles() {
        List<Article> articles = articleService.getArticles();

        return ResultData.from("S-1","게시물 리스트입니다.",articles);
    }

    @RequestMapping("/usr/article/getArticle")
    @ResponseBody
    public ResultData getArticle(int id) {
        Article article = articleService.getArticle(id);

        if (article == null) {
            return ResultData.from("F-1", Ut.f("%d번 게시물이 존재하지 않습니다.", id));
        }

        return ResultData.from("S-1", Ut.f("%d번 게시물입니다.", id), article);
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

    @RequestMapping("/usr/article/doModify")
    @ResponseBody
    public String doModify(int id, String title, String body) {
        Article article = articleService.getArticle(id);
        if (article == null) {
            return id + "번 게시물이 존재하지 않습니다.";
        }
        articleService.modifyArticle(id, title, body);
        return id + "번 게시물을 수정하였습니다.";
    }

}
