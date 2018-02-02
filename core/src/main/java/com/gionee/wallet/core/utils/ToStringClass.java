package com.gionee.wallet.core.utils;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by jeker on 2018/1/2
 *
 */
public class ToStringClass implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        Class<?> classes = this.getClass();
        return getCurrentClass(classes.getSuperclass()) + getCurrentClass(classes);
    }

    private String getCurrentClass(Class<?> classes) {
        StringBuffer sb = new StringBuffer();
        try {
            Field[] fields = classes.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                sb.append("{");
                sb.append(field.getName());
                sb.append(":");
                if (field.getType() == Integer.class) {
                    sb.append(field.getInt(this));
                } else if (field.getType() == Long.class) {
                    sb.append(field.getLong(this));
                } else if (field.getType() == Boolean.class) {
                    sb.append(field.getBoolean(this));
                } else if (field.getType() == char.class) {
                    sb.append(field.getChar(this));
                } else if (field.getType() == Double.class) {
                    sb.append(field.getDouble(this));
                } else if (field.getType() == Float.class) {
                    sb.append(field.getFloat(this));
                } else
                    sb.append(field.get(this));
                sb.append("}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
