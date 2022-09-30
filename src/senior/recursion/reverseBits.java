package senior.recursion;

/**
 *  1333 · 颠倒二进制位
 *
 *  描述
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 */
public class reverseBits {

    public long reverseBits(long n) {
        return  reverseBits(n, 32);
    }

    //普通递归
    private long reverseBits(long n, int pos){
        //递归的出口
        if (pos == 1){
            return n;
        }

        long last = n & 1;
        long ret = reverseBits(n >> 1, pos - 1);
        long result = (last << (pos - 1))  + ret;
        return  result;
    }


    //尾递归
    private long reverseBits(long n, int pos, long result){
        //递归的出口
        if (pos == 1){
            return n + result;
        }

        long last = n & 1;
        result += last << (pos - 1);
        return  reverseBits(n>>1, pos - 1, result);
    }


    private long reverseBits1(long n, int pos, long result){
        while (true){
            //递归的出口
            if (pos == 1){
                return n + result;
            }

            long last = n & 1;
            long newN = n >> 1;
            int newPos = pos - 1;
            long newResult = result + (last<<(pos - 1));
            n = newN;
            pos = newPos;
            result = newResult;
        }
    }

}
