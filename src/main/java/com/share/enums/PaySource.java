package com.share.enums;

/**
 * 放款渠道
 *
 * 删除枚举
 * ONLINE_MSXFJR("马上消费金融"), XIAO_YING("小赢理财"),OFFLINE_LEND("线下门店"),BO_HAI_XIN_TUO("渤海信托"),
 * BO_HAI_XIN_TUO_ZRB("渤海信托-真融宝"),SUI_SHOU_JI("随手记"),WAI_MAO_XIN_TUO("外贸信托"),JIA_YUAN("佳缘"),
 *
 *
 * @author sunxiaoming
 */
public enum PaySource {

    /**
     * 线上爱前进
     */
    ONLINE_IQIANJIN("线上爱钱进"),

    /**
     * 百融金服
     */
    BAI_RONG("百融金服"),

    /**
     * 凡融-真融宝
     */
    FR_ZRB("真融宝"),

    /**
     *凡融－东方证券
     */
    FR_DFZQ("凡融－东方证券"),

    /**
     * 凡融－温州银行
     */
    FR_WZCB("凡融－温州银行"),

    /**
     * 凡融－晋商银行
     */
    FR_RM_JSYHXJ("凡融－晋商银行"),
    /**
     * 凡融－众安保险
     */
    FR_RM_ZABX_FMYH("凡融－众安保险"),

    /**
     * 北海小贷
     */
    XIAODAI_BEIHAI("北海小贷"),

    /**
     * 凡融-易宝金融
     */
    FR_RM_YBJR("凡融-易宝金融"),

    /**
     * 凡融-中信信托
     */
    FR_RM_ZXTRUST_RMTC("凡融-中信信托"),

    /**
     * 凡融-PICC
     */
    FR_CAR_PICC("凡融-PICC"),

    /**
     * 凡融-正源科技
     */
    FR_CAR_ZY("凡融-正源科技"),

    /**
     * 凡融-小雨点
     */
    FR_RM_XYD_RMTC("凡融-小雨点"),

    /**
     * 凡融-江苏淘车
     */
    FR_RYH_JSTC("凡融-江苏淘车"),

    /**
     * 凡融-海尔消金
     */
    FR_HAIER_XJ("凡融-海尔消金"),

    /**
     * 天津融租
     */
    RZZL("天津融租"),

    /**
     * 凡融-PICC民生
     */
    FR_CAR_PICC_CMBC_RMTC("凡融-PICC-民生"),

    /**
     * 凡融-智度小贷
     */
    FR_RYH_GZZD("凡融-智度小贷"),

    /**
     * 凡融-智度北海小贷
     */
    FR_RYH_GZZD1("凡融-智度北海小贷"),

    /**
     * 凡融-光大信托
     */
    FR_RM_CEB("凡融-光大信托");

    private final String type;

    private PaySource(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }


    public static PaySource judgeExit(String name) {

        for (PaySource paySource : values()) {
            if (name .equals(paySource.name())) {
                return paySource;
            }
        }
        return null;
    }

}
