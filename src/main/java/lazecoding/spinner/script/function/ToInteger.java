package lazecoding.spinner.script.function;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class ToInteger implements Function {
    @Override
    public Object call(Object[] paras, Context ctx) {
        return Integer.valueOf(paras[0].toString());
    }
}
