# 二维数组回形打印

示例

```
1 2 3
4 5 6
7 8 9
```

输出 1 2 3 6 9 8 7 4 5

能明确打印点从 0,0 开始

打印顺序 就是 左到右  上到下  右到左 下到上 循环处理

那看代码



```java
 public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int time = 0;  //5行4列，输出顺序为1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,。。
        int M = a.length;
        int N = a[0].length;
        printD(a, M, N);
    }

    private static void printRC(int[][] matrix, int startX, int startY, int endX, int endY) {
        boolean isRow = startX == endX;
        boolean isRise = isRow ? startY < endY : startX < endX;
        if (isRow) {
            if (isRise) {
                for (int i = startY; i <= endY; i++) {
                    System.out.print(matrix[startX][i] + " ");
                }
            } else {
                for (int i = startY; i >= endY; i--) {
                    System.out.print(matrix[startX][i] + " ");
                }
            }
        } else {
            if (isRise) {
                for (int i = startX; i <= endX; i++) {
                    System.out.print(matrix[i][startY] + " ");
                }
            } else {
                for (int i = startX; i >= endX; i--) {
                    System.out.print(matrix[i][startY] + " ");
                }
            }
        }
    }


    public static void printD(int a[][], int totalRowNum, int totalColNum) {
        int startX = 0; //起始点X
        int startY = 0; //起始点Y
        int endX = totalRowNum - 1; //结束点 确认什么时候可以拐弯
        int endY = totalColNum - 1; //结束点
        //循环
        while (startX <= endX || startY <= endY) {
            if (startY <= endY) { // 左到右
                //第一圈 0 0 0 3
                printRC(a, startX, startY, startX, endY);
            } else {
                break;
            }
            if (startX + 1 <= endX) {//从上到下
                printRC(a, startX + 1, endY, endX, endY);
            } else {
                break;
            }
            if (endY - 1 >= startY) {//从右到左
                printRC(a, endX, endY - 1, endX, startY);
            } else {
                break;
            }
            if (endX - 1 >= startX + 1)//从下到上
            {
                printRC(a, endX - 1, startY, startX + 1, startY);
            } else {
                break;
            }
            System.out.println();
            System.out.println("********************");

            //一圈完毕
            startX++;
            startY++;
            endX--;
            endY--;
        }
    }
```

