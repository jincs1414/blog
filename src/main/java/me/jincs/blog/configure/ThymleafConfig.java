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
    @Value("${thymeleaf.cdn.thirdParty.prefix:}")
    private String cdnThirdPartyPrefix;
    @Value("${thymeleaf.cdn.selfParty.prefix:}")
    private String cdnSelfPartyPrefix;

    @Autowired
    public ThymleafConfig(SpringTemplateEngine templateEngine) {
        templateEngine.setLinkBuilder(new CdnLinkBuilder());
    }

    public class CdnLinkBuilder implements ILinkBuilder {
        private ILinkBuilder standardLinkBuilder = new StandardLinkBuilder();
        private String[] suffixArray = {".js", ".css", "png"};
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
            if (isHandingType(s)) {
                if (!StringUtils.isEmpty(cdnSelfPartyPrefix) && s.startsWith("/selfParty")) {
                    s = s.replace("/selfParty", "");
                    return cdnSelfPartyPrefix + s;
                }
                if (!StringUtils.isEmpty(cdnThirdPartyPrefix) && s.startsWith("/thirdParty")) {
                    s = s.replace("/thirdParty", "");
                    return cdnThirdPartyPrefix + s;
                }
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


