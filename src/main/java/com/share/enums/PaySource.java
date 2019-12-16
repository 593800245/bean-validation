package com.share.enums;

/**
 * 放款渠道
 *
 * @author guozhe
 */
public enum PaySource {

    /**
     * 你猜
     */
    BUGAODUNI("你猜");

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
            if (name.equals(paySource.name())) {
                return paySource;
            }
        }
        return null;
    }

}
