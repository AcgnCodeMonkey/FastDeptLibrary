package com.xujl.utilslibrary.data;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by xujl on 2017/6/23.
 */

public class JsonUtil {
    /**
     * data为数组类型
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Response<T> fromJsonArrayResponse (String json, Class clazz) {
        // 生成List 中的 List
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据List生成完整的Result>
        Type type = new ParameterizedTypeImpl(Response.class, new Type[]{listType});
        return new Gson().fromJson(json, type);
    }

    /**
     * data为对象类型
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Response<T> fromJsonResponse (String json, Class clazz) {
        Type type = new ParameterizedTypeImpl(Response.class, new Class[]{clazz});
        return new Gson().fromJson(json, type);
    }

    public static <T> T fromJson (String json, Class<T> classOfT) {
        return new Gson().fromJson(json, classOfT);
    }

    public static String toJson (Object object) {
        return new Gson().toJson(object);
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] args;

        public ParameterizedTypeImpl (Class raw, Type[] args) {
            this.raw = raw;
            this.args = args != null ? args : new Type[0];
        }

        @Override
        public Type[] getActualTypeArguments () {
            return args;
        }

        @Override
        public Type getRawType () {
            return raw;
        }

        @Override
        public Type getOwnerType () {
            return null;
        }
    }
}
