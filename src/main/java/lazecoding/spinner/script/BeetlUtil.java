package lazecoding.spinner.script;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class BeetlUtil {

    private static StringTemplateResourceLoader resourceLoader;
    private static Configuration cfg;
    private static GroupTemplate groupTemplate;

    static {
        try {
            //初始化代码
            resourceLoader = new StringTemplateResourceLoader();
            cfg = Configuration.defaultConfiguration();
            groupTemplate = new GroupTemplate(resourceLoader, cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GroupTemplate getGroupTemplate() {
        return groupTemplate;
    }

}
