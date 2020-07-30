package show.tmh.darklaunch;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 测试灰度组件
 *
 * @author yuhao
 * @date 2020/7/30 8:59 下午
 */
public class DarkLaunchTest {

    @Test
    public void testDarkLaunch(){
        DarkLaunch darkLaunch = new DarkLaunch();
//        for (int i = 0; i < 10; i++) {
//            boolean pass = darkLaunch.dark("a", new Random().nextLong());
//            System.out.println(pass);
//        }
        System.out.println(darkLaunch.dark("b",50));
        System.out.println(darkLaunch.dark("b",100));
        System.out.println(darkLaunch.dark("b",130));
        System.out.println(darkLaunch.dark("b",1300));
    }
}
