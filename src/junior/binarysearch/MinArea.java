package junior.binarysearch;

/**
 * 600 · 包裹黑色像素点的最小矩形
 *
 * https://www.lintcode.com/problem/600/description
 *
 * 描述
 * 一个由二进制矩阵表示的图，0 表示白色像素点，1 表示黑色像素点。黑色像素点是联通的，即只有一块黑色区域。
 * 像素是水平和竖直连接的，给一个黑色像素点的坐标 (x, y) ，返回囊括所有黑色像素点的矩阵的最小面积。
 *
 * 样例
 * 样例 1:
 *
 * 输入：["0010","0110","0100"]，x=0，y=2
 * 输出：6
 * 解释：
 * 矩阵左上角坐标是(0, 1), 右下角的坐标是(2, 2)
 *
 * 输入：["1110","1100","0000","0000"], x = 0, y = 1
 * 输出：6
 * 解释：
 * 矩阵左上角坐标是(0,  0), 右下角坐标是(1, 2)
 *
 */
public class MinArea {

    public static void main(String[] args) {
        char[][] image = {
            {'0', '0', '1', '0'},
            {'0', '1', '1', '0'},
            {'0', '1', '0', '0'}
        };
       int area =  minArea(image, 0, 2);
       System.out.print("the result is " + area);
    }

    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public static int minArea(char[][] image, int x, int y) {
        if (null == image || image.length == 0 || image[0].length == 0){
            return 0;
        }
        int n = image.length;
        int m = image[0].length;
        // write your code here
        int leftIndex = findLeft(image, 0, y);// 找到左边界
        int rightIndex = findRight(image, y, m - 1);//右边界
        int topIndex = findTop(image, 0, x);//上边界
        int bottomIndex = findBottom(image, x, n-1);//下边界
        int result = (rightIndex - leftIndex + 1)* (bottomIndex - topIndex + 1); // 利用边界乘积， 求area。
        return  result;
    }

    private static int findLeft(char[][] image, int start, int end){
        while (start + 1 < end) {
            int mid = start + (end - start >> 1);
            if (isEmptyColum(image, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (isEmptyColum(image, start)){
            return end;
        }
        return start;// 因为 题意中 （x, y）坐标点对应的就是1， 所以一定存在，最后放心大胆的返回值即可。
    }

    private static int findRight(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start >> 1);
            if (isEmptyColum(image, mid)){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (isEmptyColum(image, end)){
            return start;
        }
        return end;// 因为 题意中 （x, y）坐标点对应的就是1， 所以一定存在，最后放心大胆的返回值即可。
    }

    private static int findTop(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start >> 1);
            if (isEmptyRow(image, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (isEmptyRow(image, start)){
            return end;
        }
        return start;// 因为 题意中 （x, y）坐标点对应的就是1， 所以一定存在，最后放心大胆的返回值即可。
    }


    private static int findBottom(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start >> 1);
            if (isEmptyRow(image, mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (isEmptyRow(image, end)){
            return start;
        }
        return end;// 因为 题意中 （x, y）坐标点对应的就是1， 所以一定存在，最后放心大胆的返回值即可。
    }

    private static boolean isEmptyColum(char[][] image, int col){
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1'){
                return false;
            }
        }
        return true;
    }

    private static boolean isEmptyRow(char[][] image, int row){
        for (int i = 0; i < image[row].length; i++) {
            if (image[row][i] == '1') {
               return false;
            }
        }
        return true;
    }
}
