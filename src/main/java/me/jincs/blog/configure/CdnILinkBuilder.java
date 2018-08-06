package me.jincs.blog.configure;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.ILinkBuilder;

import java.util.Map;

public class CdnILinkBuilder implements ILinkBuilder {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer getOrder() {
        return null;
    }

    @Override
    public String buildLink(IExpressionContext iExpressionContext, String s, Map<String, Object> map) {
        return null;
    }
}
