package lazecoding.spinner.flow.node;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 节点
 * TODO 节点类型：执行动作、循环、延时、异步等
 *
 * @author lazecoding
 */
public class Node {

    /**
     * 节点 ID
     */
    private String nodeId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点编号，流程内唯一
     */
    private String nodeCode;

    /**
     * 节点类型
     */
    private String type;

    /**
     * 下一个节点处理方式
     */
    private String nextProceedType;

    /**
     * 默认下个节点
     */
    private Node nextNode;

    /**
     * 分支
     */
    private List<Branch> branches = new ArrayList<>();



    public Node(String name) {
        this.name = name;
    }

    public Node(String nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

    public Node(String nodeId, String name, String nodeCode) {
        this.nodeId = nodeId;
        this.name = name;
        this.nodeCode = nodeCode;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getType() {
        return type;
    }


    public void setNextNode(Node nextNode) {
        this.nextProceedType = ProceedType.NODE.getType();
        this.nextNode = nextNode;
    }

    /**
     * 增加分支
     */
    public void addBranch(Condition condition, Node nextNode) {
        this.nextProceedType = ProceedType.BRANCH.getType();
        branches.add(new Branch(condition, nextNode));
    }

    /**
     * 节点执行动作
     *
     * @param context 上下文
     */
    public void execute(Context context) {
        // 1. TODO 执行当前节点任务
        System.out.println(name + " 在执行任务 nodeId:" + nodeId);
        // 2. 下一个节点
        if (ProceedType.NODE.getType().equals(nextProceedType)) {
            if (!ObjectUtils.isEmpty(nextNode)) {
                nextNode.execute(context);
            }
        }
        if (ProceedType.BRANCH.getType().equals(nextProceedType)) {
            if (!CollectionUtils.isEmpty(branches)) {
                for (Branch branch : branches) {
                    Condition condition = branch.getCondition();
                    Node nextNode = branch.getNextNode();
                    if (!ObjectUtils.isEmpty(condition) && !ObjectUtils.isEmpty(nextNode)) {
                        if (branch.getCondition().isPass(context)) {
                            branch.getNextNode().execute(context);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取当前节点的下一个节点
     */
    public List<Node> getNextNodes() {
        List<Node> nodes = new ArrayList<>();
        if (!ObjectUtils.isEmpty(nextNode)) {
            nodes.add(nextNode);
        }
        if (!CollectionUtils.isEmpty(branches)) {
            for (Branch branch : branches) {
                Node nextNode = branch.getNextNode();
                if (!ObjectUtils.isEmpty(nextNode)) {
                    nodes.add(nextNode);
                }
            }
        }
        return nodes;
    }

    /**
     * 节点处理方式
     */
    static enum ProceedType {

        /**
         * 节点
         */
        NODE("node", "节点"),


        /**
         * 条件分支
         */
        BRANCH("branch", "条件分支");

        /**
         * 处理方式
         */
        private final String type;

        /**
         * 描述
         */
        private final String desc;

        ProceedType(String type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }
    }

}
