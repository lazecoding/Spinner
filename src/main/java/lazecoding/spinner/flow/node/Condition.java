package lazecoding.spinner.flow.node;

/**
 * 条件
 *
 * TODO 支持关联业务，自定义条件
 */
public class Condition {

    private String conditionId;

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * 是否通过条件判定
     */
    public boolean isPass(Context context) {
        return true;
    }
}
