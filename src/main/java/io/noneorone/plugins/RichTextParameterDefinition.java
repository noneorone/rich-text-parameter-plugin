package io.noneorone.plugins;

import hudson.Extension;
import hudson.model.*;
import net.sf.json.JSONObject;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.*;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 富文本参数插件
 *
 * @author wangm
 */
public class RichTextParameterDefinition extends StringParameterDefinition {

    /**
     * 是否支持将最终的内容值转为base64字符串
     */
    private boolean base64Support;

    @DataBoundConstructor
    public RichTextParameterDefinition(String name, String defaultValue, String description) {
        super(name, defaultValue, description);
    }

    public RichTextParameterDefinition(String name) {
        this(name, null, null);
    }

    public boolean isBase64Support() {
        return base64Support;
    }

    @DataBoundSetter
    public void setBase64Support(boolean base64Support) {
        this.base64Support = base64Support;
    }

    @Override
    public ParameterDefinition copyWithDefaultValue(ParameterValue defaultValue) {
        if (defaultValue instanceof StringParameterValue) {
            StringParameterValue value = (StringParameterValue) defaultValue;
            return new RichTextParameterDefinition(getName(), value.getValue(), getDescription());
        }
        return super.copyWithDefaultValue(defaultValue);
    }

    /**
     * 获取上次保存成功的值作为默认值来显示
     * @return RichTextParameterValue
     */
    @Override
    public StringParameterValue getDefaultParameterValue() {
        ParameterValue lastValue = ProjectUtils.getLastValue(this, true);
        String value = (lastValue instanceof StringParameterValue) ? ((StringParameterValue) lastValue).getValue() : getDefaultValue();
        return new StringParameterValue(getName(), value, getDescription());
    }

    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        RichTextParameterValue value = req.bindJSON(RichTextParameterValue.class, jo);
        if (isTrim() && value != null) {
            value.doTrim();
        }
        if (value != null) {
            value.setBase64Support(isBase64Support());
            value.setDescription(getDescription());
        }
        return value;
    }

    @Override
    public ParameterValue createValue(String str) {
        RichTextParameterValue value = new RichTextParameterValue(getName(), str, getDescription());
        value.setBase64Support(isBase64Support());
        if (isTrim()) {
            value.doTrim();
        }
        return value;
    }

    @Extension
    @Symbol({"richTextParameter", "richText"})
    public static class DescriptorImpl extends ParameterDefinition.ParameterDescriptor {
//        public DescriptorImpl() {
//            load();
//        }

        @Override
        public void doHelp(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
            super.doHelp(req, rsp);
        }

        @Override
        public String getValuePage() {
            return super.getValuePage();
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public String getDisplayName() {
            return Messages.RichTextParameterDefinition_DescriptorImpl_DisplayName();
        }

    }

}
