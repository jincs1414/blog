package me.jincs.blog.model;

import me.jincs.blog.domain.ArticleDomain;

/**
 * 博客模型接口
 */
public interface Iblog {
    /**
     * 发布博客文章
     *
     * @param articleDomain 文章内容
     * @return 博客对应的文章id
     */
    String post(ArticleDomain articleDomain);

    /**
     * 删除博客文章
     *
     * @param articleId 博客对应的文章id
     * @return 删除结果
     */
    boolean delete(String articleId);
}
