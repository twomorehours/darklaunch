package show.tmh.darklaunch.config;

/**
 * 灰度规则
 *
 * @author yuhao
 * @date 2020/7/30 7:37 下午
 */
public class DarkRule {

    private String key;
    private boolean enable;
    private String rule;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
