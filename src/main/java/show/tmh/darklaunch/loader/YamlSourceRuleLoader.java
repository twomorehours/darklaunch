package show.tmh.darklaunch.loader;

import org.yaml.snakeyaml.Yaml;
import show.tmh.darklaunch.config.DarkRulesConfig;

import java.io.InputStream;

/**
 * 从yaml加载rule
 *
 * @author yuhao
 * @date 2020/7/30 8:40 下午
 */
public class YamlSourceRuleLoader implements RuleLoader {

    private String fileName;

    public YamlSourceRuleLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public DarkRulesConfig load() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(
                fileName);
        Yaml yaml = new Yaml();
        return yaml.loadAs(resourceAsStream, DarkRulesConfig.class);
    }
}
