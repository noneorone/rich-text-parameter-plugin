package io.noneorone.plugins;

import hudson.model.AbstractBuild;
import hudson.model.StringParameterValue;
import hudson.util.VariableResolver;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 富文本参数值
 */
public class RichTextParameterValue extends StringParameterValue {

    /**
     * 是否支持将最终的内容值转为base64字符串
     */
    private boolean base64Support;

    public void setBase64Support(boolean base64Support) {
        this.base64Support = base64Support;
    }

    @DataBoundConstructor
    public RichTextParameterValue(String name, String value) {
        super(name, value);
    }

    public RichTextParameterValue(String name, String value, String description) {
        super(name, value, description);
    }

    @Override
    public VariableResolver<String> createVariableResolver(AbstractBuild<?, ?> build) {
        return new VariableResolver<String>() {
            @Override
            public String resolve(String name) {
                if (StringUtils.isNotEmpty(value)) {
                    String content = value;
                    if (base64Support) {
                        content = Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
                    }
                    return RichTextParameterValue.this.name.equals(name) ? content : null;
                } else {
                    return null;
                }
            }
        };
    }
}
