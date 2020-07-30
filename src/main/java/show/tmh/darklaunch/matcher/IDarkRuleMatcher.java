package show.tmh.darklaunch.matcher;

/**
 * 规则匹配接口
 *
 * @author yuhao
 * @date 2020/7/30 7:44 下午
 */
public interface IDarkRuleMatcher {

    /**
     * 是否通过灰度
     *
     * @param value 自定义值
     * @return 是否通过
     */
    boolean matcher(long value);
}
