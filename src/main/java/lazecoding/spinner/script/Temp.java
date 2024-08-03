package lazecoding.spinner.script;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Script;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;

import java.io.IOException;

public class Temp {


    public static void main(String[] args) throws IOException {

        GroupTemplate groupTemplate = BeetlUtil.getGroupTemplate();
        //获取模板
        String templateConetent = "222 \n${If(ToInt($root_key)>ToInt('6'),'777777777','666666666')} \n 1111 ";
        Template template = groupTemplate.getTemplate(templateConetent);
        template.binding("name", "Beetl");
        template.binding("title", "Eye");
        template.binding("$root_key", "7");
        //渲染结果
        BeetlException e = template.validate();
        if (e != null) {
            ErrorInfo error = new ErrorInfo(e);
            int line = error.getErrorTokenLine();
            String errorToken = error.getErrorTokenText();
            String type = error.getType();
        }
        String str = template.render();
        System.out.println(str);
    }
}
