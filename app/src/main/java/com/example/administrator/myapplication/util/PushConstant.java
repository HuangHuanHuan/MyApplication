package com.example.administrator.myapplication.util;

/**
 * @author hongrongyao
 * @function
 * @date 2017/12/21 0021
 */
public class PushConstant {


    /**
     * push的 log tag
     */
    public static final String PUSH_LOG_TAG = "pushlog";
    /**
     * preferences file
     */
    public static final String SP_NAME_PUSH = "sp_name_push";
    /**
     *推送类型sp的key
     */
    public static final String SP_KEY_PUSH_TOKEN_TYPE = "sp_key_push_token_type";
    /**
     * 应用默认的推送类型，目前是小米
     */
    public static final int DEFAULT_PUSH_TOKEN_TYPE = 1;
    /**
     * 当前设备上当前app的唯一标示sp的key
     */
    public static final String SP_KEY_PUSH_REG_ID = "sp_key_push_reg_id";
    /**
     * 默认当前设备上当前app的唯一标示
     */
    public static final String DEFAULT_PUSH_REG_ID = "";


    /**
     * 小米推送标识
     */
    public static final int XIAO_MI_PUSH_TOKEN_TYPE = 1;
    /**
     * 小米客户端的身份标识
     */
    public static final String XIAO_MI_PUSH_APP_ID = "2882303761517613031";
    public static final String XIAO_MI_PUSH_APP_KEY = "5351761377031";
    /**
     * 小米推送regid的sp的key
     */
    public static final String SP_KEY_XIAO_MI_PUSH_REG_ID ="sp_key_xiao_mi_push_reg_id";
    /**
     * 默认的小米推送regid
     */
    public static final String DEFAULT_XIAO_MI_PUSH_REG_ID ="default_xiao_mi_push_reg_id";
    /**
     * 当前版本的sp的key（小米推送升级用）
     */
    public static final String SP_KEY_CURRENT_VERSION_CODE_XIAO_MI = "sp_key_current_version_code_xiao_mi";
    /**
     * 默认的value当前版本(小米)
     */
    public static final String DEFAULT_CURRENT_VERSION_CODE_XIAO_MI = "default_current_version_code_xiao_mi";


    /**
     * 极光推送标识
     */
    public static final int JI_GUANG_PUSH_TOKEN_TYPE = 0;
    /**
     * 极光推送regid的sp的key
     */
    public static final String SP_KEY_JI_GUANG_PUSH_REG_ID ="sp_key_ji_guang_push_reg_id";
    /**
     * 默认的极光推送regid
     */
    public static final String DEFAULT_JI_GUANG_PUSH_REG_ID ="default_ji_guang_push_reg_id";

    /**
     * 当前版本的sp的key（极光推送升级用）
     */
    public static final String SP_KEY_CURRENT_VERSION_CODE_JI_GUANG= "sp_key_current_version_code_ji_guang";

    /**
     * 默认的value当前版本(极光)
     */
    public static final String DEFAULT_CURRENT_VERSION_CODE_JI_GUANG = "default_current_version_code_ji_guang";


    /**
     * 行为
     */
    public static final String PUSH_ACTION = "songviewcode";
    /**
     * 行为编码，歌曲专辑播放
     */
    public static final String SONG_ALBUM = "songAlbum";
    public static final String SONG_ALBUM_ID = "id";
    public static final String SONG_ALBUM_INDEX = "index";
    /**
     * 行为编码，软件更新
     */
    public static final String SOFT_UPDATE = "softUpdate";
    public static final String SOFT_UPDATE_SOFT_URL = "Url";
    /**
     * 行为编码，跳转内部地址
     */
    public static final String TARGERT_INNERURL = "targertInnerURL";
    public static final String TARGERT_INNERURL_URL = "url";
    /**
     * 行为编码，跳转外部地址
     */
    public static final String TARGERT_OUTURL = "targertOutURL";
    public static final String TARGERT_OUTURL_URL = "url";


    /**
     * 跳转PushPopupActivity的key
     */
    public static final String PUSH_POPUP_ACTIVITY_TITLE = "push_popup_activity_title";
    public static final String PUSH_POPUP_ACTIVITY_DESCRIPTION = "push_popup_activity_description";
    public static final String PUSH_POPUP_ACTIVITY_URL_ACTION = "push_popup_activity_urlAction";
    public static final String PUSH_POPUP_ACTIVITY_IS_FROM_NOTIFICATION = "push_popup_activity_is_from_notification";
}
