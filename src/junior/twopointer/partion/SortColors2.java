package junior.twopointer.partion;

/**
 * 143 · 颜色分类 II
 *
 * https://www.lintcode.com/problem/143/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
 *
 */
public class SortColors2 {

    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (null == colors || colors.length == 0){
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int startIndex, int endIndex, int fromColor, int ToColor){
        if (fromColor == ToColor){
            return;
        }
        if (startIndex >= endIndex){
            return;
        }
        int midColor = fromColor + (ToColor - fromColor)/2;
        int left = startIndex;
        int right = endIndex;
        while (left <= right){
            while (left <= right && colors[left] <= midColor){
                left ++;
            }

            while (left <= right && colors[right] > midColor){
                right --;
            }

            if (left <= right){
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left ++ ;
                right --;
            }
        }
        rainbowSort(colors, startIndex, right, fromColor, midColor);
        rainbowSort(colors, left, endIndex, midColor + 1, ToColor);
    }


}
