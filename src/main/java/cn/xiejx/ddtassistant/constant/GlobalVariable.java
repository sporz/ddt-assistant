package cn.xiejx.ddtassistant.constant;

import cn.xiejx.ddtassistant.collect.InfoCollectDto;
import cn.xiejx.ddtassistant.dm.DmDdt;
import cn.xiejx.ddtassistant.type.BaseType;
import cn.xiejx.ddtassistant.type.TypeConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sleepybear
 */
@Slf4j
public class GlobalVariable {

    public static boolean isAdmin = false;

    public static final String ROOT_PATH = new File("").getAbsolutePath().replace("\\", "/") + "/";

    public static Map<String, List<String>> templateImgMap = new HashMap<>();
    public static final Map<String, String> GLOBAL_MAP = new ConcurrentHashMap<>();
    public static final Map<Integer, DmDdt> DM_DDT_MAP = new ConcurrentHashMap<>();
    public static final Map<String, BaseType> BASE_TYPE_MAP = new ConcurrentHashMap<>();

    public static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(10, 100, 10, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler((t1, e) -> log.error(e.getMessage(), e));
        return t;
    }, new ThreadPoolExecutor.DiscardPolicy());

    public static final InfoCollectDto INFO_COLLECT_DTO = new InfoCollectDto();

    public static List<String> getTemplateImgList(String template) {
        return getTemplateImgList(Collections.singletonList(template));
    }

    public static List<String> getTemplateImgList(String template, boolean includeTemp) {
        return getTemplateImgList(Collections.singletonList(template), includeTemp);
    }

    public static List<String> getTemplateImgList(List<String> templates) {
        return getTemplateImgList(templates, false);
    }

    public static List<String> getTemplateImgList(List<String> templates, boolean includeTemp) {
        if (MapUtils.isEmpty(templateImgMap)) {
            templateImgMap = TypeConstants.TemplatePrefix.getTemplateImgMap();
            if (MapUtils.isEmpty(templateImgMap)) {
                templateImgMap.put("空", new ArrayList<>());
            }
        }
        List<String> list = new ArrayList<>();
        for (String template : templates) {
            List<String> strings = templateImgMap.get(template);
            if (CollectionUtils.isEmpty(strings)) {
                continue;
            }
            list.addAll(strings);
        }
        if (!includeTemp) {
            list.removeIf(s -> s.contains(TypeConstants.TemplatePrefix.TEMP_STR));
        }
        return list;
    }
}
