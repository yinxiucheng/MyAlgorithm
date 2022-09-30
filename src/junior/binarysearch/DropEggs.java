package junior.binarysearch;

/**
 * 254 · 丢鸡蛋
 *
 * https://www.lintcode.com/problem/254/solution/21772?fromId=161&_from=collection
 *
 * 描述
 * 楼有 n 层高，鸡蛋若从 k 层或以上扔，就会碎。从 k 层以下扔，就不会碎。
 *
 * 现在给两个鸡蛋，用最少的扔的次数找到 k。返回最坏情况下次数。
 *
 *
 */
public class DropEggs {

    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
//        # 假设第一次扔的位置是x，
//        # 如果第一次扔的碎了，则结果小于x，从小到大寻找所有的1～x-1， 扔的次数为x
//        # 如果第一次扔没有碎，则第二次扔的位置为 x + (x-1)，
//        # 如果第二次扔碎了，则结果小于x + (x-1)，从小到大寻找所有的x+1～x + (x-1)-1， 扔的次数为x
//        # 如果第二次扔没碎，则第三次扔的位置为 x + (x-1) + (x-2)...
//        # 找到每次扔的位置，这些位置可以把1～n划分为x段，而且第一段正好也是x，可以得到 x + (x-1) + (x-2) +...+ 1 >= n
//        # binary search

        long start = 1;
        long end = n;
        while (start + 1< end){
            long mid = start + (end - start) / 2;
            if (mid * (mid + 1) / 2 == n){// 寻找左边第一个，需要右边兜底， 等号用在右边。
                end = mid;
            }else if (mid * (mid + 1) / 2 > n){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (start * (start + 1)/2 == n){ //寻找左边第一个。
            return (int)start;
        }
        return (int)end;
    }
}
