package com.tuling.learnSpring.propertyEditor;

import com.tuling.learnSpring.pojo.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Description: 类描述
 * @date: 2024/04/26 23:04
 * @author: Heavy rain
 **/
public class StringToUserEditor extends PropertyEditorSupport implements PropertyEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        user.setName(text);
        this.setValue(user);
    }
}
