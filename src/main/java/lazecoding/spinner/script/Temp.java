package lazecoding.spinner.script;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;

import java.io.IOException;

public class Temp {


    public static void main(String[] args) throws IOException {

        GroupTemplate groupTemplate = BeetlUtil.getGroupTemplate();
        //获取模板
        String templateContent = "${If(ToInt(__root_key)>ToInt('6'),ToInt(__root_v1),ToInt(__root_v2))}";
        Template template = groupTemplate.getTemplate(templateContent);

        BeetlException e = template.validate();
        if (e != null) {
            ErrorInfo error = new ErrorInfo(e);
            int line = error.getErrorTokenLine();
            String errorToken = error.getErrorTokenText();
            String type = error.getType();
        }
        template.binding("__root_key", "7");
        template.binding("__root_v1", "111111");
        template.binding("__root_v2", "222222");

        //渲染结果
        String str = template.render();
        System.out.println(str);
    }
}
