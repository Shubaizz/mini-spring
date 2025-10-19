package org.springframework.core.convert.converter;

import java.util.Set;

/**
 * ClassName: GenericConverter
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:49
 * Version: 1.0
 */
public interface GenericConverter {

    // 获取可转换的类型
    Set<ConvertiblePair> getConvertibleTypes();

    // 转换
    Object convert(Object source, Class sourceType, Class targetType);

    public static final class ConvertiblePair {
        private final Class<?> sourceType;

        private final Class<?> targetType;

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return this.sourceType;
        }

        public Class<?> getTargetType() {
            return this.targetType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ConvertiblePair.class) {
                return false;
            }
            ConvertiblePair other = (ConvertiblePair) obj;
            return this.sourceType.equals(other.sourceType) && this.targetType.equals(other.targetType);

        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }
    }
}
