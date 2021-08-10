package com.goiot.blelib.protocol;

/**
 * 握手协议
 */
public class HandshakeData {

    /**
     * 桩 SN 7  AC40055
     */
    private String stake;

    /**
     * user 1
     *     0x00：桩主
     *     0x01-0x07：分享者
     *     其他无效；
     */
    private byte user;

    /**
     * userid 4
     * 用户 ID：1000008
     */
    private byte[] userid;

    /**
     * 权限时间-启 4 时间戳
     */
    private byte[] authstarttime;

    /**
     * 权限时间-末 4 时间戳
     */
    private byte[] authendtime;

    /**
     * 对时时钟 4 时间戳
     */
    private byte[] timestamp;

}
