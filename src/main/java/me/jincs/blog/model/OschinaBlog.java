package me.jincs.blog.model;

import me.jincs.blog.domain.ArticleDomain;

/**
 * 开源中国
 */
public class OschinaBlog implements Iblog {
    @Override
    public String post(ArticleDomain articleDomain) {
        return null;
    }

    @Override
    public boolean delete(String ArticleId) {
        return false;
    }
}
