package com.example.administrator.myapplication.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Converter;

/**
 * Created by Administrator on 2018/1/11.
 */

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+.*[0-9]*");

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    public T convert(ResponseBody value) throws IOException {
        Object var8;
        try {
            String response = value.string();
            JSONObject jsonObject = null;

            try {
                jsonObject = new JSONObject(response);
                String jsonReader = jsonObject.getString("Data");
                L.e("加密数据= " + jsonReader);

                try {
                    jsonReader = AES256Cipher.AES_Decode(jsonReader);
                } catch (Exception var13) {
                    var13.printStackTrace();
                }

                L.e("解密数据= " + jsonReader);
                this.putDataBack(jsonObject, jsonReader);
            } catch (JSONException var14) {
                var14.printStackTrace();
            }

            MediaType mediaType = value.contentType();
            Charset charset = mediaType != null?mediaType.charset(Util.UTF_8):Util.UTF_8;
            ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes());
            JsonReader jsonReader1 = this.gson.newJsonReader(new InputStreamReader(inputStream, charset));
            var8 = this.adapter.read(jsonReader1);
        } finally {
            value.close();
        }

        return (T) var8;
    }

    private void putDataBack(JSONObject jsonObject, String data) throws JSONException {
        if(data.startsWith("[")) {
            if("[]".equals(data)) {
                jsonObject.put("Data", (Object)null);
            } else {
                JSONArray jo = new JSONArray(data);
                jsonObject.put("Data", jo);
            }
        } else if(data.startsWith("{")) {
            if("{}".equals(data)) {
                jsonObject.put("Data", (Object)null);
            } else {
                JSONObject jo1 = new JSONObject(data);
                jsonObject.put("Data", jo1);
            }
        } else if(this.isNumeric(data)) {
            if(data.contains(".")) {
                jsonObject.put("Data", Double.valueOf(data));
            } else {
                jsonObject.put("Data", Long.valueOf(data));
            }
        } else {
            if(data.startsWith("\"")) {
                data = data.substring(1, data.length());
            }

            if(data.endsWith("\"")) {
                data = data.substring(0, data.length() - 1);
            }

            jsonObject.put("Data", data);
        }

    }

    private boolean isNumeric(String str) {
        Matcher isNum = NUMBER_PATTERN.matcher(str);
        return isNum.matches();
    }

    private boolean isJson(String json) {
        if(TextUtils.isEmpty(json)) {
            return true;
        } else {
            try {
                (new JsonParser()).parse(json);
                return true;
            } catch (JsonParseException var3) {
                return false;
            }
        }
    }
}
