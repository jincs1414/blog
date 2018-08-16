package me.jincs.blog.controller;

import me.jincs.blog.domain.ArticleDomain;
import me.jincs.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {

        model.addAttribute("articleList", getArticleList());
        return "homePage/index";
    }


    private List<ArticleDomain> getArticleList() {
        List articleList = new ArrayList();
        ArticleDomain articleDomain = new ArticleDomain();
        articleDomain.setUrl("https://www.cnblogs.com/vaiyanzi/p/9432931.html");
        articleDomain.setTitle("基础查找算法（顺序无序查找算法和递归二叉查找算法）");
        articleDomain.setContext("一、顺序无序查找算法 顺序查找算法很简单也很好理解，就是在一个序列中从前往后遍历集合直到查到目标值为止。通常查找最大值和最小值都是这种方法。 1、顺序查找的一般实现： 查找最大值 查找最小值 顺序查找的特点是，查找效率依赖于元素所在的位置，如果在第一个，那就是秒查，效率非常高，如果是最后一个那么就要 ...");

        ArticleDomain articleDomain2 = new ArticleDomain();
        articleDomain2.setUrl("https://www.cnblogs.com/vaiyanzi/p/9432931.html");
        articleDomain2.setTitle("基础查找算法（顺序无序查找算法和递归二叉查找算法）");
        articleDomain2.setContext("一、顺序无序查找算法 顺序查找算法很简单也很好理解，就是在一个序列中从前往后遍历集合直到查到目标值为止。通常查找最大值和最小值都是这种方法。 1、顺序查找的一般实现： 查找最大值 查找最小值 顺序查找的特点是，查找效率依赖于元素所在的位置，如果在第一个，那就是秒查，效率非常高，如果是最后一个那么就要 ...");

        ArticleDomain articleDomain3 = new ArticleDomain();
        articleDomain3.setUrl("https://www.cnblogs.com/haifengbolgs/p/9409891.html");
        articleDomain3.setTitle("初识机器学习——吴恩达《Machine Learning》学习笔记（十二）");
        articleDomain3.setContext("支持向量机(Support Vector Machines) 优化目标(Optimization objective) SVM与logistic回归 SVM假设函数 直观上对大间隔的理解(Large Margin Intuition) SVM也被称为大间距分类器，SVM代价函数的图像分析： 大间距分 ...");

        articleList.add(articleDomain);
        articleList.add(articleDomain2);
        articleList.add(articleDomain3);

        List dbArticle = articleRepository.findAll();
        articleList.addAll(dbArticle);
        return articleList;
    }
}
