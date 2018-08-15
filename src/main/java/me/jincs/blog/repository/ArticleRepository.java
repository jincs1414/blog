package me.jincs.blog.repository;

import me.jincs.blog.domain.ArticleDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleDomain, Long> {
}
