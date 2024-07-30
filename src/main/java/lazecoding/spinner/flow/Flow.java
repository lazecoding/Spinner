package lazecoding.spinner.flow;

import lazecoding.spinner.flow.node.Condition;
import lazecoding.spinner.flow.node.Context;
import lazecoding.spinner.flow.node.Node;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 流程
 */
public class Flow {

    /**
     * 流程 Id
     */
    private String flowId;

    /**
     * 起始节点
     */
    private Node root;


    public Flow(Node root) {
        this.root = root;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 校验流程设计是否合理
     */
    public boolean verify() {
        if (ObjectUtils.isEmpty(root)) {
            return false;
        }
        List<Node> nodes = getFlowNodes();
        Set<String> nodeCodes = new HashSet<>();
        if (!CollectionUtils.isEmpty(nodes)) {
            for (Node node : nodes) {
                nodeCodes.add(node.getNodeCode());
            }
        }
        if (nodeCodes.size() != nodes.size()) {
            return false;
        }
        // TODO 校验
        return true;
    }

    /**
     * 获取全部流程节点
     **/
    public List<Node> getFlowNodes() {
        Map<String, Node> nodeMap = new HashMap<>();
        scanNode(root, nodeMap);
        if (CollectionUtils.isEmpty(nodeMap)) {
            return null;
        }
        List<Node> flowNodes = new ArrayList<>();
        for (Map.Entry<String, Node> entry : nodeMap.entrySet()) {
            flowNodes.add(entry.getValue());
        }
        return flowNodes;
    }

    /**
     * 遍历节点
     */
    private void scanNode(Node node, Map<String, Node> nodeMap) {
        if (ObjectUtils.isEmpty(node)) {
            return;
        }
        nodeMap.put(node.getNodeId(), node);
        if (!ObjectUtils.isEmpty(node)) {
            List<Node> nodes = node.getNextNodes();
            if (!CollectionUtils.isEmpty(nodes)) {
                for (Node item : nodes) {
                    scanNode(item, nodeMap);
                }
            }
        }
    }

    public void execute(Context context) {
        if (verify()) {
            root.execute(context);
        }
    }

    public static void main(String[] args) {
        // 创建节点
        Node startNode = new Node("1", "Start Node", "1");
        Node node1 = new Node("2", "Node 1", "2");
        Node node2 = new Node("3", "Node 2", "3");
        Node node3 = new Node("4", "Node 3", "4");
        Node endNode = new Node("5", "End Node", "5");

        // 设置条件和分支
        startNode.addBranch(new Condition(), node1);
        startNode.addBranch(new Condition(), node2);
        node1.addBranch(new Condition(), node3);
        node1.setNextNode(endNode);
        node2.setNextNode(endNode);
        node3.setNextNode(endNode);

        // 创建上下文
        Context context = new Context("26");

        // 执行工作流
        Flow flow = new Flow(startNode);
        flow.execute(context);
    }
}
