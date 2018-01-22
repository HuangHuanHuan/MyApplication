package com.example.administrator.myapplication.util;


import com.example.administrator.myapplication.MainApplication;

/**
 * @author hongrongyao
 * @function 推送相关本地sp数据操作
 * @date 2017/12/28 0028
 */
public class PushDataHelper {
    private static PushDataHelper instance;
    private SharedPreferencesHelper sharedPreferencesHelper;
    public PushDataHelper(){
        sharedPreferencesHelper = new SharedPreferencesHelper(MainApplication.getContext(),PushConstant.SP_NAME_PUSH);
    }

    public static PushDataHelper getInstance(){
        if ( null == instance) {
            synchronized (PushDataHelper.class) {
                if ( null == instance ) {
                    instance = new PushDataHelper();
                }
            }
        }
        return instance;
    }

    /**需要上报服务器的数据（头部）*/

    public int getPushTokenType(){
        return sharedPreferencesHelper.getInt(PushConstant.SP_KEY_PUSH_TOKEN_TYPE,PushConstant.DEFAULT_PUSH_TOKEN_TYPE);
    }

    public void setPushTokenType(int pushTokenType){
        sharedPreferencesHelper.putInt(PushConstant.SP_KEY_PUSH_TOKEN_TYPE,pushTokenType);
    }

    public String getPushRegId(){
        return sharedPreferencesHelper.getString(PushConstant.SP_KEY_PUSH_REG_ID,PushConstant.DEFAULT_PUSH_REG_ID);
    }

    public void setPushRegId(String pushRegId){
        sharedPreferencesHelper.putString(PushConstant.SP_KEY_PUSH_REG_ID,pushRegId);
    }

    /**小米推送*/

    public String getXiaoMiCurrentVersionCode(){
        return sharedPreferencesHelper.getString(PushConstant.SP_KEY_CURRENT_VERSION_CODE_XIAO_MI,PushConstant.DEFAULT_CURRENT_VERSION_CODE_XIAO_MI);
    }

    public void setXiaoMiCurrentVersionCode(String currentVersionCode){
        sharedPreferencesHelper.putString(PushConstant.SP_KEY_CURRENT_VERSION_CODE_XIAO_MI,currentVersionCode);
    }

    public String getXiaoMiRegId(){
        return sharedPreferencesHelper.getString(PushConstant.SP_KEY_XIAO_MI_PUSH_REG_ID,PushConstant.DEFAULT_XIAO_MI_PUSH_REG_ID);
    }
    public void setXiaoMiRegId(String xiaoMiRegId){
        sharedPreferencesHelper.putString(PushConstant.SP_KEY_XIAO_MI_PUSH_REG_ID,xiaoMiRegId);
    }

    /**极光推送*/

    public String getJiGuangCurrentVersionCode(){
        return sharedPreferencesHelper.getString(PushConstant.SP_KEY_CURRENT_VERSION_CODE_JI_GUANG,PushConstant.DEFAULT_CURRENT_VERSION_CODE_JI_GUANG);
    }

    public void setJiGuangCurrentVersionCode(String currentVersionCode){
        sharedPreferencesHelper.putString(PushConstant.SP_KEY_CURRENT_VERSION_CODE_JI_GUANG,currentVersionCode);
    }

    public String getJiGuangRegId(){
        return sharedPreferencesHelper.getString(PushConstant.SP_KEY_JI_GUANG_PUSH_REG_ID,PushConstant.DEFAULT_JI_GUANG_PUSH_REG_ID);
    }
    public void setJiGuangRegId(String jiGuangMiRegId){
        sharedPreferencesHelper.putString(PushConstant.SP_KEY_JI_GUANG_PUSH_REG_ID,jiGuangMiRegId);
    }
}
