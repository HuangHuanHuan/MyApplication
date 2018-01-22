package com.example.administrator.myapplication.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/1/11.
 */

public class ConvertUtils {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private ConvertUtils() {
        throw new UnsupportedOperationException("u can\'t instantiate me...");
    }

    public static String bytes2HexString(byte[] bytes) {
        if(bytes == null) {
            return null;
        } else {
            int len = bytes.length;
            if(len <= 0) {
                return null;
            } else {
                char[] ret = new char[len << 1];
                int i = 0;

                for(int j = 0; i < len; ++i) {
                    ret[j++] = hexDigits[bytes[i] >>> 4 & 15];
                    ret[j++] = hexDigits[bytes[i] & 15];
                }

                return new String(ret);
            }
        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if(src != null && src.length > 0) {
            byte[] var2 = src;
            int var3 = src.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                byte aSrc = var2[var4];
                int v = aSrc & 255;
                String hv = Integer.toHexString(v);
                if(hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static byte[] hexString2Bytes(String hexString) {
        if(isSpace(hexString)) {
            return null;
        } else {
            int len = hexString.length();
            if(len % 2 != 0) {
                hexString = "0" + hexString;
                ++len;
            }

            char[] hexBytes = hexString.toUpperCase().toCharArray();
            byte[] ret = new byte[len >> 1];

            for(int i = 0; i < len; i += 2) {
                ret[i >> 1] = (byte)(hex2Dec(hexBytes[i]) << 4 | hex2Dec(hexBytes[i + 1]));
            }

            return ret;
        }
    }

    private static int hex2Dec(char hexChar) {
        if(hexChar >= 48 && hexChar <= 57) {
            return hexChar - 48;
        } else if(hexChar >= 65 && hexChar <= 70) {
            return hexChar - 65 + 10;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static byte[] chars2Bytes(char[] chars) {
        if(chars != null && chars.length > 0) {
            int len = chars.length;
            byte[] bytes = new byte[len];

            for(int i = 0; i < len; ++i) {
                bytes[i] = (byte)chars[i];
            }

            return bytes;
        } else {
            return null;
        }
    }

    public static char[] bytes2Chars(byte[] bytes) {
        if(bytes == null) {
            return null;
        } else {
            int len = bytes.length;
            if(len <= 0) {
                return null;
            } else {
                char[] chars = new char[len];

                for(int i = 0; i < len; ++i) {
                    chars[i] = (char)(bytes[i] & 255);
                }

                return chars;
            }
        }
    }

    public static long memorySize2Byte(long memorySize, int unit) {
        return memorySize < 0L?-1L:memorySize * (long)unit;
    }

    public static double byte2MemorySize(long byteNum, int unit) {
        return byteNum < 0L?-1.0D:(double)byteNum / (double)unit;
    }

    @SuppressLint({"DefaultLocale"})
    public static String byte2FitMemorySize(long byteNum) {
        return byteNum < 0L?"shouldn\'t be less than zero!":(byteNum < 1024L?String.format("%.3fB", new Object[]{Double.valueOf((double)byteNum + 5.0E-4D)}):(byteNum < 1048576L?String.format("%.3fKB", new Object[]{Double.valueOf((double)byteNum / 1024.0D + 5.0E-4D)}):(byteNum < 1073741824L?String.format("%.3fMB", new Object[]{Double.valueOf((double)byteNum / 1048576.0D + 5.0E-4D)}):String.format("%.3fGB", new Object[]{Double.valueOf((double)byteNum / 1.073741824E9D + 5.0E-4D)}))));
    }

    public static long timeSpan2Millis(long timeSpan, int unit) {
        return timeSpan * (long)unit;
    }

    public static long millis2TimeSpan(long millis, int unit) {
        return millis / (long)unit;
    }

    @SuppressLint({"DefaultLocale"})
    public static String millis2FitTimeSpan(long millis, int precision) {
        if(millis > 0L && precision > 0) {
            StringBuilder sb = new StringBuilder();
            String[] units = new String[]{"天", "小时", "分钟", "秒", "毫秒"};
            int[] unitLen = new int[]{86400000, 3600000, '\uea60', 1000, 1};
            precision = Math.min(precision, 5);

            for(int i = 0; i < precision; ++i) {
                if(millis >= (long)unitLen[i]) {
                    long mode = millis / (long)unitLen[i];
                    millis -= mode * (long)unitLen[i];
                    sb.append(mode).append(units[i]);
                }
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static String bytes2Bits(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        byte[] var2 = bytes;
        int var3 = bytes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte aByte = var2[var4];

            for(int j = 7; j >= 0; --j) {
                sb.append((char)((aByte >> j & 1) == 0?'0':'1'));
            }
        }

        return sb.toString();
    }

    public static byte[] bits2Bytes(String bits) {
        int lenMod = bits.length() % 8;
        int byteLen = bits.length() / 8;
        if(lenMod != 0) {
            for(int bytes = lenMod; bytes < 8; ++bytes) {
                bits = "0" + bits;
            }

            ++byteLen;
        }

        byte[] var6 = new byte[byteLen];

        for(int i = 0; i < byteLen; ++i) {
            for(int j = 0; j < 8; ++j) {
                var6[i] = (byte)(var6[i] << 1);
                var6[i] = (byte)(var6[i] | bits.charAt(i * 8 + j) - 48);
            }
        }

        return var6;
    }

    public static ByteArrayOutputStream input2OutputStream(InputStream is) {
        if(is == null) {
            return null;
        } else {
            Object b;
            try {
                ByteArrayOutputStream e = new ByteArrayOutputStream();
                byte[] b1 = new byte[1024];

                int len;
                while((len = is.read(b1, 0, 1024)) != -1) {
                    e.write(b1, 0, len);
                }

                ByteArrayOutputStream var4 = e;
                return var4;
            } catch (IOException var8) {
                var8.printStackTrace();
                b = null;
            } finally {
                CloseUtils.closeIO(new Closeable[]{is});
            }

            return (ByteArrayOutputStream)b;
        }
    }

    public ByteArrayInputStream output2InputStream(OutputStream out) {
        return out == null?null:new ByteArrayInputStream(((ByteArrayOutputStream)out).toByteArray());
    }

    public static byte[] inputStream2Bytes(InputStream is) {
        return is == null?null:input2OutputStream(is).toByteArray();
    }

    public static InputStream bytes2InputStream(byte[] bytes) {
        return bytes != null && bytes.length > 0?new ByteArrayInputStream(bytes):null;
    }

    public static byte[] outputStream2Bytes(OutputStream out) {
        return out == null?null:((ByteArrayOutputStream)out).toByteArray();
    }

    public static OutputStream bytes2OutputStream(byte[] bytes) {
        if(bytes != null && bytes.length > 0) {
            ByteArrayOutputStream os = null;

            Object var3;
            try {
                os = new ByteArrayOutputStream();
                os.write(bytes);
                ByteArrayOutputStream e = os;
                return e;
            } catch (IOException var7) {
                var7.printStackTrace();
                var3 = null;
            } finally {
                CloseUtils.closeIO(new Closeable[]{os});
            }

            return (OutputStream)var3;
        } else {
            return null;
        }
    }

    public static String inputStream2String(InputStream is, String charsetName) {
        if(is != null && !isSpace(charsetName)) {
            try {
                return new String(inputStream2Bytes(is), charsetName);
            } catch (UnsupportedEncodingException var3) {
                var3.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static InputStream string2InputStream(String string, String charsetName) {
        if(string != null && !isSpace(charsetName)) {
            try {
                return new ByteArrayInputStream(string.getBytes(charsetName));
            } catch (UnsupportedEncodingException var3) {
                var3.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static String outputStream2String(OutputStream out, String charsetName) {
        if(out != null && !isSpace(charsetName)) {
            try {
                return new String(outputStream2Bytes(out), charsetName);
            } catch (UnsupportedEncodingException var3) {
                var3.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static OutputStream string2OutputStream(String string, String charsetName) {
        if(string != null && !isSpace(charsetName)) {
            try {
                return bytes2OutputStream(string.getBytes(charsetName));
            } catch (UnsupportedEncodingException var3) {
                var3.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat format) {
        if(bitmap == null) {
            return null;
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(format, 100, baos);
            return baos.toByteArray();
        }
    }

    public static Bitmap bytes2Bitmap(byte[] bytes) {
        return bytes != null && bytes.length != 0? BitmapFactory.decodeByteArray(bytes, 0, bytes.length):null;
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if(drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmap = (BitmapDrawable)drawable;
            if(bitmap.getBitmap() != null) {
                return bitmap.getBitmap();
            }
        }

        Bitmap bitmap1;
        if(drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            bitmap1 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565);
        } else {
            bitmap1 = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565);
        }

        Canvas canvas = new Canvas(bitmap1);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap1;
    }

    public static Drawable bitmap2Drawable(Context ctx, Bitmap bitmap) {
        return bitmap == null?null:new BitmapDrawable(ctx.getResources(), bitmap);
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat format) {
        return drawable == null?null:bitmap2Bytes(drawable2Bitmap(drawable), format);
    }

    public static Drawable bytes2Drawable(Context ctx, byte[] bytes) {
        return bytes == null?null:bitmap2Drawable(ctx, bytes2Bitmap(bytes));
    }

    public static Bitmap view2Bitmap(View view) {
        if(view == null) {
            return null;
        } else {
            Bitmap ret = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(ret);
            Drawable bgDrawable = view.getBackground();
            if(bgDrawable != null) {
                bgDrawable.draw(canvas);
            } else {
                canvas.drawColor(-1);
            }

            view.draw(canvas);
            return ret;
        }
    }

    public static boolean isSpace(String s) {
        if(s == null) {
            return true;
        } else {
            int i = 0;

            for(int len = s.length(); i < len; ++i) {
                if(!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
}
