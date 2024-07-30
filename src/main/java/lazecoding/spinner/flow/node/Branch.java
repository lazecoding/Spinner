package lazecoding.spinner.flow.node;



/**
 * 分支
 */
public class Branch {

    /**
     * 条件判断
     */
    private Condition condition;

    /**
     * 下一个节点
     */
    private Node nextNode;

    public Branch(Condition condition, Node nextNode) {
        this.condition = condition;
        this.nextNode = nextNode;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
