package show.tmh.darklaunch;

import show.tmh.darklaunch.config.DarkRule;
import show.tmh.darklaunch.config.DarkRulesConfig;
import show.tmh.darklaunch.loader.RuleLoader;
import show.tmh.darklaunch.loader.YamlSourceRuleLoader;
import show.tmh.darklaunch.matcher.RootMatcher;
import show.tmh.darklaunch.matcher.RuleConfigMatcher;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 灰度入口
 *
 * @author yuhao
 * @date 2020/7/30 6:30 下午
 */
public class DarkLaunch {

    private RootMatcher rootMatcher;
    private RuleLoader ruleLoader;
    private ScheduledExecutorService executorService;

    public DarkLaunch() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        rootMatcher = new RootMatcher();
        ruleLoader = new YamlSourceRuleLoader("darklaunch.yaml");
        initRule();
        refreshRules();
    }

    public boolean dark(String key, long value) {
        return rootMatcher.dark(key, value);
    }

    private void refreshRules() {
        executorService.scheduleAtFixedRate(() -> initRule(), 1L, 1L, TimeUnit.MINUTES);
    }

    private void initRule() {
        DarkRulesConfig rulesConfig = ruleLoader.load();
        List<DarkRule> rules = rulesConfig.getRules();
        for (DarkRule rule : rules) {
            if (!rule.isEnable()) {
                continue;
            }
            rootMatcher.addMatcher(rule.getKey(), new RuleConfigMatcher(rule));
        }
    }


}
