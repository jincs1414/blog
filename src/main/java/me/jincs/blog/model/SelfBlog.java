package me.jincs.blog.model;

import me.jincs.blog.domain.ArticleDomain;
import me.jincs.blog.repository.ArticleRepository;
import me.jincs.blog.util.SpringBeanUtil;

/**
 * 本地自建博客
 */
public class SelfBlog implements Iblog {
    private ArticleRepository articleRepository = SpringBeanUtil.getBean(ArticleRepository.class);

    @Override
    public String post(ArticleDomain articleDomain) {
        return articleRepository.save(articleDomain).getId().toString();
    }

    @Override
    public boolean delete(String articleId) {
        ArticleDomain articleDomain = new ArticleDomain();
        articleDomain.setId(Long.valueOf(articleId));
        articleRepository.delete(articleDomain);
        return true;
    }
}
