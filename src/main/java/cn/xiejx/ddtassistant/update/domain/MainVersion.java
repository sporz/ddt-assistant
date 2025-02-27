package cn.xiejx.ddtassistant.update.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2023/02/02 21:03
 */
@Data
public class MainVersion implements Serializable {
    private static final long serialVersionUID = 3749859724180075947L;

    private List<MainVersionInfo> versions;
}
