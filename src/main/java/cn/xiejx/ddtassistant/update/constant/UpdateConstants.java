package cn.xiejx.ddtassistant.update.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2023/02/03 10:16
 */
public class UpdateConstants {
    public enum VersionTypeEnum {
        /**
         * 说明
         */
        INNER_VERSION(1, "内部测试版", 2),
        ALPHA_VERSION(2, "alpha测试版", 4),
        BETA_VERSION(3, "beta测试版", 8),
        STABLE_VERSION(4, "正式版", 16),
        ;
        private final Integer type;
        private final String name;
        private final Integer mask;

        VersionTypeEnum(Integer type, String name, Integer mask) {
            this.type = type;
            this.name = name;
            this.mask = mask;
        }

        public Integer getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public Integer getMask() {
            return mask;
        }

        public static String getVersionTypeEnum(Integer type) {
            for (VersionTypeEnum versionTypeEnum : values()) {
                if (versionTypeEnum.getMask().equals(type)) {
                    return versionTypeEnum.name;
                }
            }
            return "";
        }

        public static String getVersionTypeEnumByVersion(Integer versionType) {
            if (versionType == null) {
                return "";
            }
            return getVersionTypeEnum(versionType);
        }
    }

    public enum TypeEnum {
        /**
         * 类型
         */
        TEXT(0),
        BINARY(1),
        ;

        static final Set<String> FILE_TYPE_SET = new HashSet<>(Arrays.asList(".bat", ".json", ".txt", ".xml", ".pom", ".java", ".yml", ".html", ".js", ".css"));

        private final Integer type;

        TypeEnum(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }

        public static TypeEnum getType(Integer type) {
            for (TypeEnum typeEnum : values()) {
                if (typeEnum.getType().equals(type)) {
                    return typeEnum;
                }
            }
            return BINARY;
        }

        public static TypeEnum getTypeByFilename(String filename) {
            if (StringUtils.isBlank(filename)) {
                return BINARY;
            }

            if (!filename.contains(".")) {
                return TEXT;
            }

            String fileExtension = filename.substring(filename.lastIndexOf("."));
            if (FILE_TYPE_SET.contains(fileExtension.toLowerCase())) {
                return TEXT;
            }
            return BINARY;
        }
    }

    public enum UpdateStrategyEnum {
        /**
         * 更新策略
         */
        NO_ACTION(0),
        UPDATE_ALL(1),
        UPDATE_RECOMMEND(2),
        DOWNLOAD_ONLY_NOT_EXIST(3),
        DELETE(-1),
        ;

        private final Integer type;

        UpdateStrategyEnum(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }

        public static UpdateStrategyEnum getUpdateStrategyEnumByType(Integer type) {
            if (type == null) {
                return NO_ACTION;
            }

            for (UpdateStrategyEnum updateStrategyEnum : values()) {
                if (updateStrategyEnum.getType().equals(type)) {
                    return updateStrategyEnum;
                }
            }
            return NO_ACTION;
        }
    }

}
