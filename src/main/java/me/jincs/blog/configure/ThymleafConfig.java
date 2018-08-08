package me.jincs.blog.configure;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.ILinkBuilder;
import org.thymeleaf.linkbuilder.StandardLinkBuilder;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

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
        private String[] suffixArray = {".js", ".css"};
        @Override
        public String getName() {
            return "cdn builder";
        }

        @Override
        public Integer getOrder() {
            return 1;
        }

        @Override
        public String buildLink(IExpressionContext iExpressionContext, String s, Map<String, Object> map) {
            if (!StringUtils.isEmpty(cdnPrefix) && isHandingType(s)) {
                return cdnPrefix + s;
            }
            return standardLinkBuilder.buildLink(iExpressionContext, s, map);
        }

        private boolean isHandingType(String s) {
            for (String suffix : suffixArray) {
                if (s.endsWith(suffix)) {
                    return true;
                }
            }
            return false;
        }
    }
}


