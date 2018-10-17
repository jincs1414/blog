package me.jincs.blog.model;

import me.jincs.blog.domain.ArticleDomain;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客园
 */
public class CnblogsBlog implements Iblog {
    String apiUrl = "https://rpc.cnblogs.com/metaweblog/ghostr";

    @Override
    public String post(ArticleDomain articleDomain) {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL(apiUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Map<String, String> m = new HashMap<String, String>();
        m.put("title", articleDomain.getTitle());
        m.put("link", articleDomain.getUrl());
        m.put("description", articleDomain.getContext());
        Object[] params = new Object[]{"default", "逐浪少年", "1414641776@qq.com", m, true};
        String ret = null;
        try {
            ret = (String) client.execute("metaWeblog.newPost", params);
        } catch (XmlRpcException e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    @Override
    public boolean delete(String ArticleId) {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL(apiUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[] params = new Object[]{"ghostr", ArticleId, "逐浪少年", "1414641776@qq.com", true};

        try {
            String ret = (String) client.execute("blogger.deletePost", params);
        } catch (XmlRpcException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
