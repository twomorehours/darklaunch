package show.tmh.darklaunch.matcher;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.springframework.util.StringUtils;
import show.tmh.darklaunch.config.DarkRule;

/**
 * 配置文件规则解析器
 *
 * @author yuhao
 * @date 2020/7/30 7:50 下午
 */
public class RuleConfigMatcher implements IDarkRuleMatcher {


    private RangeSet<Long> rangeSet = TreeRangeSet.create();
    private int percent = -1;

    public RuleConfigMatcher(DarkRule rule) {
        parseFrom(rule);
    }

    private void parseFrom(DarkRule rule) {
        String ruleStr = rule.getRule().trim();
        if (StringUtils.isEmpty(ruleStr)) {
            throw new IllegalArgumentException();
        }
        if (ruleStr.startsWith("%")) {
            this.percent = Integer.parseInt(ruleStr.substring(1));
        } else {
            String[] split = ruleStr.split(",");
            for (String s : split) {
                if (s.contains("-")) {
                    String[] range = s.split("-");
                    long lower = Long.parseLong(range[0]);
                    long upper = Long.parseLong(range[1]);
                    rangeSet.add(Range.closed(lower, upper));
                } else {
                    long val = Long.parseLong(s);
                    rangeSet.add(Range.closed(val, val));
                }
            }
        }
    }

    @Override
    public boolean matcher(long value) {
        return rangeSet.contains(value)
                || (value % 100) <= percent;
    }
}
