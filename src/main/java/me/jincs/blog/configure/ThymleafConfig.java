package me.jincs.blog.configure;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.linkbuilder.AbstractLinkBuilder;
import org.thymeleaf.linkbuilder.ILinkBuilder;
import org.thymeleaf.linkbuilder.StandardLinkBuilder;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.util.Validate;
import org.unbescape.uri.UriEscape;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Configuration
public class ThymleafConfig {
    @Value("${thymeleaf.cdn.prefix:}")
    private String cdnPrefix;

    @Autowired
    public ThymleafConfig(SpringTemplateEngine templateEngine) {
        templateEngine.setLinkBuilder(new CdnLinkBuilder());
    }

    public class CdnLinkBuilder implements ILinkBuilder {
        private ILinkBuilder standardLinkBuilder = new StandardLinkBuilder();

        @Override
        public String getName() {
            return "cdn builder";
        }

        @Override
        public Integer getOrder() {
            return 2;
        }

        @Override
        public String buildLink(IExpressionContext iExpressionContext, String s, Map<String, Object> map) {
            if (!StringUtils.isEmpty(cdnPrefix) && (s.endsWith(".js") || s.endsWith(".css"))) {
                return cdnPrefix + s;
            }
            return standardLinkBuilder.buildLink(iExpressionContext, s, map);
        }
    }
}


