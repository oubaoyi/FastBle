package com.goiot.blelib.protocol;

/**
 * 握手响应协议
 * 1、预约开启时刻：时-分 例子：22 时 30 分 —— 0x16 0x1E
 * 2、权限应答中“无效”：桩号不对、有效期超限；
 * 3、充电桩握手状态：充电桩应答握手成功与否
 * 4、充电桩蓝牙钥匙状态：指是否使能充电桩禁用
 * 5、软件版本号/硬件版本号/蓝牙软件版本号：保留一位小数；如 V1.2 实际为：12
 */
public class HandshakeResultData {
    /**
     * 桩 SN 7 AC40055
     */
    private String stake;

    /**
     * user 1
     * 0x00：桩主
     * 0x01-0x07：分享者
     * 其他无效；
     */
    private byte user;

    /**
     * userid 4
     * 用户 ID：1000008
     */
    private byte[] userid;

    /**
     * 权限应答 1
     *     0：无效；
     *     1：有效；
     *     其他值：无效
     */
    private byte authresult;

    /**
     * 预约开启时刻 2 时-分
     */
    private byte[] makestarttime;

    /**
     * 预约充电电流 1 充电电流大小（A）
     */
    private byte makeelectricity;


    /**
     * 最小充电电流 1 充电电流下限值（A）
     */
    private byte minelectricity;


    /**
     * 最大充电电流 1 充电电流上限值（A）
     */
    private byte maxelectricity;

    /**
     * 对时时钟 4 时间戳
     */
    private byte[] timestamp;

    /**
     *  运行状态 1
     *     [bit0]充电桩故障状态 0：正常
     *     1：故障
     *     [bit1]充电枪连接状态 0：未连接
     *     1：已连接
     *     [bit2-3]充电桩充电状态 0：空闲
     *     1：等待车辆启动中 2：充电中
     *     3：充电停止
     *     [bit4]充电桩握手状态 0：未握手
     *     1：握手成功
     *     [bit5]充电桩解锁状态 0：未解锁
     *     1：已解锁
     *     [bit6]预约状态：0：未预约，1：
     *     已预约
     *     [bit7]保留，置 0
     */
    private byte runstate;

    /**
     * 软件版本号 1 例如：1.1 ，11.2 的 10 倍
     */
    private byte softver;

    /**
     * 硬件版本号 1 例如：1.1 ，11.2 的 10 倍
     */
    private byte hardwarever;

    /**
     * 蓝牙软件版本 1 例如：1.1 ，11.2 的 10 倍
     */
    private byte blever;

    /**
     * 累计充电次数 4 每充一次累加 1
     */
    private byte[] chargenum;

    /**
     * 累计故障次数 4 每故障状态变化一次累加 1
     */
    private byte[] faultnum;

    /**
     * 即插即充设置 1
     *     1：已开启 2：已关闭
     */
    private byte immediatelycharge;

    /**
     * 充电桩蓝牙钥匙状态
     * 0：充电桩蓝牙钥匙功能关闭
     * 1：充电桩蓝牙钥匙功能开启
     * 默认 0
     */
    private byte blekeystate;
}
