package lazecoding.spinner.script.function;

import lazecoding.spinner.script.BeetlUtil;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

/**
 * IF(logic, value1, value2) 如果logic为true，则返回value1， 否则返回value2
 *
 * @author lazecoding
 */
public class If implements Function {
    @Override
    public Object call(Object[] paras, Context ctx) {
        if (paras.length != 3) {
            throw new IllegalArgumentException("IF function requires 3 arguments.");
        }

        // 执行逻辑表达式
        String logicExpression = paras[0].toString();
        GroupTemplate groupTemplate = BeetlUtil.getGroupTemplate();
        Template logicTemplate = groupTemplate.getTemplate(logicExpression);
        logicTemplate.binding(ctx.globalVar);
        boolean logic = Boolean.parseBoolean(logicTemplate.render());

        // 根据逻辑值返回对应的结果
        return logic ? paras[1] : paras[2];
    }
}
