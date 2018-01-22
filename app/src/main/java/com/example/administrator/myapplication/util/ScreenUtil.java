package com.example.administrator.myapplication.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/11.
 */

public class ScreenUtil {
    public static final int INVALID = -2147483648;

    public ScreenUtil() {
    }

    public static int getCurrentScreenWidth(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        boolean isLand = isOrientationLandscape(context);
        return isLand?metrics.heightPixels:metrics.widthPixels;
    }

    public static int getCurrentScreenHeight(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        boolean isLand = isOrientationLandscape(context);
        return isLand?metrics.widthPixels:metrics.heightPixels;
    }

    public static boolean isOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources mResources;
        if(context == null) {
            mResources = Resources.getSystem();
        } else {
            mResources = context.getResources();
        }

        return mResources.getDisplayMetrics();
    }

    public static void setAbsListViewHeight(AbsListView absListView, int lineNumber, int verticalSpace) {
        int totalHeight = getAbsListViewHeight(absListView, lineNumber, verticalSpace);
        ViewGroup.LayoutParams params = absListView.getLayoutParams();
        params.height = totalHeight;
        ((ViewGroup.MarginLayoutParams)params).setMargins(0, 0, 0, 0);
        absListView.setLayoutParams(params);
    }

    public static int getAbsListViewHeight(AbsListView absListView, int lineNumber, int verticalSpace) {
        int totalHeight = 0;
        int w = View.MeasureSpec.makeMeasureSpec(0, 0);
        int h = View.MeasureSpec.makeMeasureSpec(0, 0);
        absListView.measure(w, h);
        ListAdapter mListAdapter = (ListAdapter)absListView.getAdapter();
        if(mListAdapter == null) {
            return totalHeight;
        } else {
            int count = mListAdapter.getCount();
            int remain;
            View listItem;
            if(absListView instanceof ListView) {
                for(remain = 0; remain < count; ++remain) {
                    listItem = mListAdapter.getView(remain, (View)null, absListView);
                    listItem.measure(w, h);
                    totalHeight += listItem.getMeasuredHeight();
                }

                if(count == 0) {
                    totalHeight = verticalSpace;
                } else {
                    totalHeight += ((ListView)absListView).getDividerHeight() * (count - 1);
                }
            } else if(absListView instanceof GridView) {
                remain = count % lineNumber;
                if(remain > 0) {
                    remain = 1;
                }

                if(mListAdapter.getCount() == 0) {
                    totalHeight = verticalSpace;
                } else {
                    listItem = mListAdapter.getView(0, (View)null, absListView);
                    listItem.measure(w, h);
                    int line = count / lineNumber + remain;
                    totalHeight = line * listItem.getMeasuredHeight() + (line - 1) * verticalSpace;
                }
            }

            return totalHeight;
        }
    }

    public static void measureView(View view) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if(p == null) {
            p = new ViewGroup.LayoutParams(-1, -2);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if(lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, 1073741824);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }

        view.measure(childWidthSpec, childHeightSpec);
    }

    public static int getViewWidth(View view) {
        measureView(view);
        return view.getMeasuredWidth();
    }

    public static int getViewHeight(View view) {
        measureView(view);
        return view.getMeasuredHeight();
    }

    public static void removeSelfFromParent(View v) {
        ViewParent parent = v.getParent();
        if(parent != null && parent instanceof ViewGroup) {
            ((ViewGroup)parent).removeView(v);
        }

    }

    public static int scale(Context context, float value) {
        DisplayMetrics mDisplayMetrics = getDisplayMetrics(context);
        return scale(mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels, value);
    }

    public static int scale(int displayWidth, int displayHeight, float pxValue) {
        if(pxValue == 0.0F) {
            return 0;
        } else {
            float scale = 1.0F;

            try {
                float e = (float)displayWidth / 720.0F;
                float scaleHeight = (float)displayHeight / 1080.0F;
                scale = Math.min(e, scaleHeight);
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            return Math.round(pxValue * scale + 0.5F);
        }
    }

    public static void setTextSize(TextView textView, float sizePixels) {
        float scaledSize = (float)scale(textView.getContext(), sizePixels);
        textView.setTextSize(0, scaledSize);
    }

    public static void setTextSize(Context context, TextPaint textPaint, float sizePixels) {
        float scaledSize = (float)scale(context, sizePixels);
        textPaint.setTextSize(scaledSize);
    }

    public static void setTextSize(Context context, Paint paint, float sizePixels) {
        float scaledSize = (float)scale(context, sizePixels);
        paint.setTextSize(scaledSize);
    }

    public static void setViewSize(View view, int widthPixels, int heightPixels) {
        int scaledWidth = scale(view.getContext(), (float)widthPixels);
        int scaledHeight = scale(view.getContext(), (float)heightPixels);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if(params == null) {
            L.e(ScreenUtil.class, "setViewSize出错,如果是代码new出来的View，需要设置一个适合的LayoutParams");
        } else {
            if(widthPixels != -2147483648) {
                params.width = scaledWidth;
            }

            if(heightPixels != -2147483648) {
                params.height = scaledHeight;
            }

            view.setLayoutParams(params);
        }
    }

    public static void setPadding(View view, int left, int top, int right, int bottom) {
        int scaledLeft = scale(view.getContext(), (float)left);
        int scaledTop = scale(view.getContext(), (float)top);
        int scaledRight = scale(view.getContext(), (float)right);
        int scaledBottom = scale(view.getContext(), (float)bottom);
        view.setPadding(scaledLeft, scaledTop, scaledRight, scaledBottom);
    }

    public static void setMargin(View view, int left, int top, int right, int bottom) {
        int scaledLeft = scale(view.getContext(), (float)left);
        int scaledTop = scale(view.getContext(), (float)top);
        int scaledRight = scale(view.getContext(), (float)right);
        int scaledBottom = scale(view.getContext(), (float)bottom);
        if(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams mMarginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
            if(mMarginLayoutParams != null) {
                if(left != -2147483648) {
                    mMarginLayoutParams.leftMargin = scaledLeft;
                }

                if(right != -2147483648) {
                    mMarginLayoutParams.rightMargin = scaledRight;
                }

                if(top != -2147483648) {
                    mMarginLayoutParams.topMargin = scaledTop;
                }

                if(bottom != -2147483648) {
                    mMarginLayoutParams.bottomMargin = scaledBottom;
                }

                view.setLayoutParams(mMarginLayoutParams);
            }
        }

    }

    public static float getScreenDensity(Context ctx) {
        return ctx.getResources().getDisplayMetrics().density;
    }

    public static String getScreenResolution(Context ctx) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)ctx.getApplicationContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return width + "x" + height;
    }

    public static int[] getScreenResolutionXY(Context ctx) {
        int[] resolutionXY = new int[2];
        if(resolutionXY[0] != 0) {
            return resolutionXY;
        } else {
            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager)ctx.getApplicationContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(metrics);
            resolutionXY[0] = metrics.widthPixels;
            resolutionXY[1] = metrics.heightPixels;
            return resolutionXY;
        }
    }

    public static void turnWindowToLight(Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 1.0F;
        activity.getWindow().setAttributes(lp);
    }

    public static void turnWindowToDark(Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.7F;
        activity.getWindow().setAttributes(lp);
    }

    public static void getScreenRect(Context ctx_, Rect outrect_) {
        Display screenSize = ((WindowManager)ctx_.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        screenSize.getSize(point);
        outrect_.set(0, 0, point.x, point.y);
    }

    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getCurrentScreenWidth(activity);
        int height = getCurrentScreenHeight(activity);
        Bitmap bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;
    }

    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = getCurrentScreenWidth(activity);
        int height = getCurrentScreenHeight(activity);
        Bitmap bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }
}
