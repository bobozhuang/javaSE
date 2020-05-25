package main.java.com.bobozhuang.basic.chap06BitMap;

/**
 * description： mask代表的是移位数，n >>3 等价于 Math.floor(n / 8)， (1 << 3) - 1 = 7 = bin 111（
 * author Hubery
 * date 2020-05-08
 * version v0.0.1
 * since v0.0.1
 **/
public class BitMap {

    public byte[] bitArr;
    private static final byte mask = 3;
    private static final int maxNum = (1 << mask) - 1;
    private long count = 0;

    BitMap() {

        bitArr = new byte[1 << (Integer.SIZE - mask)];

    }


}
