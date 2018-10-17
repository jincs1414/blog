package me.jincs.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "article")
public class ArticleDomain implements Serializable {
    private String url;
    private String title;
    private String context;
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "ArticleDomain{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", id=" + id +
                '}';
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("url", url);
        map.put("title", title);
        map.put("context", context);
        return map;
    }
}
