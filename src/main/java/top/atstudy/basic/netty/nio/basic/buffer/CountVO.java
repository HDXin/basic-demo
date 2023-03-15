package top.atstudy.basic.netty.nio.basic.buffer;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: dexin.huang or harley
 * @Email: dexin.huang@paat.com
 * @Date: 2021/4/15 11:14
 * @Description
 */
@Data
public class CountVO implements Serializable {

    private long a;

    private int ax;

    private long b;

    private int bx;

    private long c;

    private int cx;

    public CountVO addA(long a) {
        this.a += a;
        this.ax++;
        return this;
    }

    public CountVO addB(long b) {
        this.b += b;
        this.bx++;
        return this;
    }

    public CountVO addC(long c) {
        this.c += c;
        this.cx++;
        return this;
    }

    public long a() {
        return this.a / this.ax;
    }

    public long b() {
        return this.b / this.bx;
    }

    public long c() {
        return this.c / this.cx;
    }

}