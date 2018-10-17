package me.jincs.blog.model;

import me.jincs.blog.domain.ArticleDomain;

import java.util.ArrayList;
import java.util.List;

public class BlogFactory implements Iblog {

    static List<Iblog> blogList = new ArrayList();

    public static void register(Iblog blog) {
        blogList.add(blog);
    }


    @Override
    public String post(ArticleDomain articleDomain) {
        for (Iblog iblog : blogList) {
            System.out.println(iblog.post(articleDomain));
        }
        ;
        return "1";
    }

    @Override
    public boolean delete(String articleId) {
        for (Iblog iblog : blogList) {
            iblog.delete(articleId);
        }
        ;
        return true;
    }
}
