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
    BUGAOSUNI("你猜");

    private final String type;

    PaySource(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }


}
