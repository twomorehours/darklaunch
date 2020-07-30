package show.tmh.darklaunch.matcher;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 匹配器入口
 *
 * @author yuhao
 * @date 2020/7/30 8:18 下午
 */
public class RootMatcher {

    private ConcurrentHashMap<String, IDarkRuleMatcher> matchers = new ConcurrentHashMap<>();


    public void addMatcher(String key, IDarkRuleMatcher matcher) {
        matchers.put(key, matcher);
    }

    public boolean dark(String key, long value) {
        IDarkRuleMatcher matcher = matchers.get(key);
        return matcher == null || matcher.matcher(value);
    }

}
