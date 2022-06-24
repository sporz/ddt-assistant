package cn.xiejx.ddtassistant.controller;

import cn.xiejx.ddtassistant.logic.CaptureLogic;
import cn.xiejx.ddtassistant.vo.StringRet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/06/24 16:26
 */
@RestController
public class CaptureController {

    @Resource
    private CaptureLogic captureLogic;

    @RequestMapping("/capture/getScreenshotPath")
    public StringRet captureScreen() {
        String path = captureLogic.captureScreen();
        return StringRet.buildSuccess(path);
    }
}
