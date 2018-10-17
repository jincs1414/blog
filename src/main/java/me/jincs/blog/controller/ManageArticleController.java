package me.jincs.blog.controller;

import me.jincs.blog.domain.ArticleDomain;
import me.jincs.blog.model.BlogFactory;
import me.jincs.blog.model.CnblogsBlog;
import me.jincs.blog.model.SelfBlog;
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
        articleDomain.setUrl("jinhan.me");
        BlogFactory.register(new CnblogsBlog());
        BlogFactory.register(new SelfBlog());
        BlogFactory blogFactory = new BlogFactory();
        blogFactory.post(articleDomain);
        return "manageArticle/article";
    }


}
