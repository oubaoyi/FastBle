package com.goiot.blelib.protocol;

public class CondBaseStructure {
    /**
     * 起始标志：代表一帧数据的开始，固定为 0x68；
     *
     * 数据长度：数据长度不超过 250 字节。其值为“序列号域+帧类型标志+消息体+帧校验域”字
     * 节数之和；
     *
     * 序列号域：数据包的发送顺序号，从 0 开始顺序增加，如果是应答数据包，则与询问数据包
     * 序号保持一致，当桩与手机断开重新建立连接或溢出后归 0；
     *
     * 帧校验域：“序列号域+帧类型标志+消息体”按字节累加和的结果；
     *
     * 所有数据高字节在前低字节在后；
     *
     * 数据加密范围：“序列号域+帧类型标志+消息体+帧检验域”执行 AES-CBC-128 算法加
     * 密，数据长度为加密后的数据长度，起始标志和数据长度采用明码传输
     *
     * 发送方发送数据需保证帧与帧间隔时间≥50ms；
     *
     * 时间戳：unix时间戳 1970 年 1 月 1 日 00：00：00 到当前的秒数
     *
     */

    /**
     * 起始标志 BCD 码 1 byte 固定码：0x68
     */
    private byte mark=0x68;

    /**
     * 数据长度 1 byte
     */
    private int len;

    /**
     * 序列号域0-255 1 byte
     */
    private byte sn;

    /**
     * 帧类型标志 BCD 码 1 byte 固定码：0x02
     */
    private byte code;

    /**
     * 消息体 N byte
     */
    private byte[] data;

    /**
     * 帧检验域 1 byte 异或校验
     */
    private byte crc;


}
