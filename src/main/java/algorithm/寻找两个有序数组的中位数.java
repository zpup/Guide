package algorithm;

public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        int[] a = new int[]{};
        int[] b = new int[]{1, 2, 3, 4, 5};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArraysA(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) * 0.5;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2; //获取 数组A的中间位置
            int j = (m + n + 1) / 2 - i; //获取 数组B的中间位置
            //说明 数组B 不为空， 数组A的i还未到最大值， B的右边的最小值 还是比 A的最大值大
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;

            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                // 排除 数组A 空的情况  并且A的最大值 大于B的最小值
                // i 需要减小
                iMax = i - 1;
            } else {
                // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;

                if (i == 0) { //数组A 空
                    maxLeft = B[j - 1];
                } else if (j == 0) { //数组B 空
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { // 数组A 到队尾 那么就是b[j]
                    minRight = B[j];
                } else if (j == n) { // 数组B 到队尾 那么就是A[i]
                    minRight = A[i];
                } else {
                    //正常的话取 最小值
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;

    }


    public static double findMedianSortedArraysPointer(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        int median = (nums1Len + nums2Len) / 2;

        int left = 0, right = 0;

        int first = 0, second = 0;

        for (int i = 0; i <= median; i++) {
            left = right;
            if (first < nums1Len && (second >= nums2Len || nums1[first] < nums2[second])) {
                right = nums1[first];
                first++;
            } else {
                right = nums2[second];
                second++;
            }

        }
        if ((nums1Len + nums2Len) % 2 > 0) {
            return right;
        } else {
            return (left + right) * 0.5;
        }

    }
}

