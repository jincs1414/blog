package me.jincs.blog.controller;

import me.jincs.blog.domain.ArticleDomain;
import me.jincs.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manageArticle")
public class ManageArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping({"index", "/"})
    public String index() {

        return "manageArticle/index";
    }

    @PostMapping("postArticle")
    public String postArticle(ArticleDomain articleDomain, Model model) {
        model.addAttribute("article", articleDomain);
        articleRepository.save(articleDomain);
        return "manageArticle/article";

    }


}
