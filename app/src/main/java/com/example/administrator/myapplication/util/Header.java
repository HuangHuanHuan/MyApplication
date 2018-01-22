package com.example.administrator.myapplication.util;

import android.support.annotation.Keep;

/**
 * Created by Administrator on 2018/1/11.
 */
@Keep
public class Header {
    /**
     * 操作系统类型
     */
    private int OSType;
    /**
     * 设备类型
     */
    private int DeviceType;
    /**
     * 平台类型
     */
    private int PlatForm;
    /**
     * 操作系统版本
     */
    private String OSVer;
    /**
     * 设备型号
     */
    private String DeviceModel;
    /**
     * 设备设置的语言
     */
    private String DeviceLang;
    /**
     * 程序语言
     */
    private String AppLang;
    /**
     * 上网类型
     */
    private int Net;
    /**
     * mac地址
     */
    private String Mac;
    /**
     * 设备分辨率
     */
    private String Screen;
    /**
     * 路由地址
     */
    private String BSSID;
    /**
     * 设备序列号
     */
    private String Serial;
    /**
     * 程序唯一标识
     */
    private String OpenID;
    /**
     * 设备唯一标识
     */
    private String IMEI;
    /**
     * 来源类型
     */
    private int DataType;
    /**
     * 是否越狱
     */
    private String JbFlag;

    /**
     * 广告标识
     */
    private String IDFA;
    /**
     * 开发者唯一标识
     */
    private String IDFV;
    /**
     * 开机启动时间
     */
    private String RTime;
    /**
     * 第三方广告标识
     */
    private String SimIDFA;

    /**
     * 项目标识
     */
    private int ProjectID;
    /**
     * 产品标识
     */
    private int ProductID;
    /**
     * 渠道标识
     */
    private int CHID;
    /**
     * 外部渠道
     */
    private String CHCode;
    /**
     * 版本标识
     */
    private int VerID;
    /**
     * 外部版本号
     */
    private String VerCode;

    /**
     * 账号标识
     */
    private int AccountID;
    /**
     * 账号标识签名
     */
    private String AccountIDSignature;
    /**
     * 登录签名
     */
    private String LoginSignature;
    /**
     * 登录时间
     */
    private int LoginStamp;
    /**
     * 登录码
     */
    private String LoginCode;
    /**
     * 会话标识
     */
    private String SessionID;
    /**
     * Token
     */
    private String Token;
    /**
     * 推送标识
     */
    private int TokenType;

    public void setTokenType(int tokenType) {
        TokenType = tokenType;
    }

    public void setOSType(int OSType) {
        this.OSType = OSType;
    }

    public void setDeviceType(int deviceType) {
        DeviceType = deviceType;
    }

    public void setPlatForm(int platForm) {
        PlatForm = platForm;
    }

    public void setOSVer(String OSVer) {
        this.OSVer = OSVer;
    }

    public void setDeviceModel(String deviceModel) {
        DeviceModel = deviceModel;
    }

    public void setDeviceLang(String deviceLang) {
        DeviceLang = deviceLang;
    }

    public void setAppLang(String appLang) {
        AppLang = appLang;
    }

    public void setNet(int net) {
        Net = net;
    }

    public void setMac(String mac) {
        Mac = mac;
    }

    public void setScreen(String screen) {
        Screen = screen;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public void setOpenID(String openID) {
        OpenID = openID;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public void setDataType(int dataType) {
        DataType = dataType;
    }

    public void setJbFlag(String jbFlag) {
        JbFlag = jbFlag;
    }

    public void setIDFA(String IDFA) {
        this.IDFA = IDFA;
    }

    public void setIDFV(String IDFV) {
        this.IDFV = IDFV;
    }

    public void setRTime(String RTime) {
        this.RTime = RTime;
    }

    public void setToken(String token) {
        Token = token;
    }

    public void setSimIDFA(String simIDFA) {
        SimIDFA = simIDFA;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public void setCHID(int CHID) {
        this.CHID = CHID;
    }

    public void setCHCode(String CHCode) {
        this.CHCode = CHCode;
    }

    public void setVerID(int verID) {
        VerID = verID;
    }

    public void setVerCode(String verCode) {
        VerCode = verCode;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public void setAccountIDSignature(String accountIDSignature) {
        AccountIDSignature = accountIDSignature;
    }

    public void setLoginSignature(String loginSignature) {
        LoginSignature = loginSignature;
    }

    public void setLoginStamp(int loginStamp) {
        LoginStamp = loginStamp;
    }

    public void setLoginCode(String loginCode) {
        LoginCode = loginCode;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }
}
