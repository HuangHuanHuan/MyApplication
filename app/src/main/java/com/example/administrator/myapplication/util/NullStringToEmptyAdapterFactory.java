package com.example.administrator.myapplication.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Administrator on 2018/1/11.
 */

public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
    public NullStringToEmptyAdapterFactory() {
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class rawType = type.getRawType();
        return rawType != String.class?null:new NullStringToEmptyAdapterFactory.StringNullAdapter();
    }

    class StringNullAdapter extends TypeAdapter<String> {
        StringNullAdapter() {
        }

        public String read(JsonReader reader) throws IOException {
            if(reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            } else {
                return reader.nextString();
            }
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if(value == null) {
                writer.nullValue();
            } else {
                writer.value(value);
            }
        }
    }
}