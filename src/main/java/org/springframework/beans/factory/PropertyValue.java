package org.springframework.beans.factory;

/**
 * ClassName: PropertyValue
 * Description: bean属性信息
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:08
 * Version: 1.0
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
