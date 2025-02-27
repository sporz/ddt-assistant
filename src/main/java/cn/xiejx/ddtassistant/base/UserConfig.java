package cn.xiejx.ddtassistant.base;

import cn.xiejx.ddtassistant.dm.Dm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author sleepybear
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class UserConfig extends BaseConfig implements Serializable {
    private static final long serialVersionUID = 4172087034701104358L;

    public static final long DEFAULT_CAPTURE_INTERVAL = 1000L;
    public static final long DEFAULT_TIMEOUT = 20000L;
    public static final String DEFAULT_SOFT_ID = "3b995690b1794ff08bad1abb88a3e451";

    public static final String DEFAULT_TYPE_ID = "7";

    private String username;
    private String password;
    /**
     * 推荐码
     */
    private String softId;
    /**
     * 打码类型
     */
    private String typeId;

    /**
     * 是否开启低余额提醒
     */
    private Boolean lowBalanceRemind;
    /**
     * 低余额提醒余额值
     */
    private Double lowBalanceNum;
    /**
     * 识屏时间间隔
     */
    private Long captureInterval;
    /**
     * 验证码出现后等待的毫秒
     */
    private Long captchaAppearDelay;
    /**
     * 出现验证码后按下的按键
     */
    private String keyPressAfterCaptchaShow;
    /**
     * 验证码消失后按下的按键
     */
    private String keyPressAfterCaptchaDisappear;
    /**
     * 验证码消失后按下的按键的延时
     */
    private Long keyPressDelayAfterCaptchaDisappear;
    /**
     * 副本大翻牌出现后的延迟毫秒
     */
    private Long pveFlopBonusAppearDelay;
    /**
     * 副本大翻牌出现后的键盘按键
     */
    private String keyPressAfterPveFlopBonus;
    /**
     * 副本大翻牌消失后延迟的毫秒
     */
    private Long pveFlopBonusDisappearDelay;
    /**
     * 副本大翻牌消失后的键盘按键
     */
    private String keyPressAfterPveFlopBonusDisappear;
    /**
     * 副本大翻牌是否截屏
     */
    private Boolean pveFlopBonusCapture;
    private Boolean pveFlopBonusCaptureMosaic;
    /**
     * 默认选项
     */
    private String defaultChoiceAnswer;
    /**
     * 验证码超时时间
     */
    private Long timeout;
    /**
     * 控制台日志输出间隔，-1 为不输出
     */
    private Long logPrintInterval;
    /**
     * 每隔时间检测有没有新的号上线，-1 为不检测
     */
    private Long detectNewWindowInterval;

    private String mouseMode;
    private String keyPadMode;

    @Override
    @JsonIgnore
    public String getFileName() {
        return "基本配置.json";
    }

    @Override
    public UserConfig defaultConfig() {
        UserConfig userConfig = new UserConfig();
        userConfig.setDefaultChoiceAnswer("A");
        userConfig.setCaptchaAppearDelay(null);
        userConfig.setKeyPressAfterCaptchaShow(null);
        userConfig.setKeyPressAfterCaptchaDisappear(null);
        userConfig.setKeyPressDelayAfterCaptchaDisappear(null);
        userConfig.setPveFlopBonusAppearDelay(null);
        userConfig.setPveFlopBonusDisappearDelay(null);
        userConfig.setKeyPressAfterPveFlopBonus(null);
        userConfig.setKeyPressAfterPveFlopBonusDisappear(null);
        userConfig.setPveFlopBonusCapture(false);
        userConfig.setSoftId(DEFAULT_SOFT_ID);
        userConfig.setCaptureInterval(DEFAULT_CAPTURE_INTERVAL);
        userConfig.setDetectNewWindowInterval(null);
        userConfig.setTimeout(DEFAULT_TIMEOUT);
        userConfig.setLogPrintInterval(30000L);
        userConfig.setMouseMode(Dm.DEFAULT_MOUSE_MODE);
        userConfig.setKeyPadMode(Dm.DEFAULT_KEY_PAD_MODE);
        return userConfig;
    }

    public void setUserConfig(UserConfig userConfig) {
        BeanUtils.copyProperties(userConfig, this);
    }

    public boolean validUserInfo() {
        return this.username != null && this.username.length() > 0 & this.password != null && this.password.length() > 0;
    }

    public boolean invalidUserInfo() {
        return !validUserInfo();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSoftId() {
        return softId;
    }

    public void setSoftId(String softId) {
        this.softId = softId;
    }

    public String getTypeId() {
        return StringUtils.isEmpty(typeId) ? DEFAULT_TYPE_ID : typeId;
    }

    public void setCaptureInterval(Long captureInterval) {
        this.captureInterval = captureInterval;
    }

    public String getKeyPressAfterCaptchaShow() {
        return keyPressAfterCaptchaShow;
    }

    public void setKeyPressAfterCaptchaShow(String keyPressAfterCaptchaShow) {
        this.keyPressAfterCaptchaShow = keyPressAfterCaptchaShow;
    }

    public String getKeyPressAfterCaptchaDisappear() {
        return keyPressAfterCaptchaDisappear;
    }

    public void setKeyPressAfterCaptchaDisappear(String keyPressAfterCaptchaDisappear) {
        this.keyPressAfterCaptchaDisappear = keyPressAfterCaptchaDisappear;
    }

    public Long getKeyPressDelayAfterCaptchaDisappear() {
        return keyPressDelayAfterCaptchaDisappear;
    }

    public void setKeyPressDelayAfterCaptchaDisappear(Long keyPressDelayAfterCaptchaDisappear) {
        this.keyPressDelayAfterCaptchaDisappear = keyPressDelayAfterCaptchaDisappear;
    }

    public String getDefaultChoiceAnswer() {
        return defaultChoiceAnswer;
    }

    public void setDefaultChoiceAnswer(String defaultChoiceAnswer) {
        this.defaultChoiceAnswer = defaultChoiceAnswer;
    }

    public Long getTimeout() {
        if (timeout == null || timeout <= 0) {
            timeout = DEFAULT_TIMEOUT;
        }
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Long getLogPrintInterval() {
        return logPrintInterval;
    }

    public void setLogPrintInterval(Long logPrintInterval) {
        this.logPrintInterval = logPrintInterval;
    }

    public Long getDetectNewWindowInterval() {
        return detectNewWindowInterval;
    }

    public void setDetectNewWindowInterval(Long detectNewWindowInterval) {
        this.detectNewWindowInterval = detectNewWindowInterval;
    }

    public void setMouseMode(String mouseMode) {
        this.mouseMode = mouseMode;
    }

    public void setKeyPadMode(String keyPadMode) {
        this.keyPadMode = keyPadMode;
    }
}
