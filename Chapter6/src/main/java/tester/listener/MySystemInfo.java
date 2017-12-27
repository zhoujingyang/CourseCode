package tester.listener;


import com.vimalselvam.testng.SystemInfo;
import org.testng.collections.Maps;

import java.util.Map;

public class MySystemInfo implements SystemInfo {
    @Override
    public Map<String, String> getSystemInfo() {
        Map<String, String> systemInfo = Maps.newHashMap();
        systemInfo.put("Test Env", "QA");
        systemInfo.put("Browser", "firefox");
        systemInfo.put("测试执行人","周景阳");
        return systemInfo;
    }
}