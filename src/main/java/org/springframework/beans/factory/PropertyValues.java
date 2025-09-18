package org.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PropertyValues
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:09
 * Version: 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue pv = (PropertyValue) this.propertyValueList.get(i);
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
