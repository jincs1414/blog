package me.jincs.blog.controller;

import me.jincs.blog.exception.NoArticleFoundException;
import me.jincs.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articleController")
public class ArticleController {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("articleShow")
    public String articleShow(Long id, Model model) {
        model.addAttribute("article", articleRepository.findById(id).orElseThrow(() -> new NoArticleFoundException()));
        return "article/articleShow";
    }
}
