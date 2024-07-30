package lazecoding.spinner.flow.node;


/**
 * 上下文
 *
 * @author lazecoding
 */
public class Context {

    /**
     * 全局上下文属性
     */
    private String globalContext;

    /**
     * 前置节点上下文属性
     */
    private String previousContext;

    public Context() {
    }

    public Context(String globalContext) {
        this.globalContext = globalContext;
    }

    public Context(String globalContext, String previousContext) {
        this.globalContext = globalContext;
        this.previousContext = previousContext;
    }

    public String getGlobalContext() {
        return globalContext;
    }

    public void setGlobalContext(String globalContext) {
        this.globalContext = globalContext;
    }

    public String getPreviousContext() {
        return previousContext;
    }

    public void setPreviousContext(String previousContext) {
        this.previousContext = previousContext;
    }
}
