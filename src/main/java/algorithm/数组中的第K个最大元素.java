package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        System.out.println(findKthLargestArr(new int[]{1, 2, 3}, 2));
    }

    public static int findKthLargestArr(int[] nums, int k) {
        //新数组存储数据 维持有序
        int[] arr = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int tmp = arr.length;


            //排序
            sort(arr, nums[i], k);

        }
        return arr[0];
    }

    private static void sort(int[] arr, int num, int k) {
        if (arr.length == 0) {
            arr[0] = num;
        } else  {
            if (arr[0] > num) {
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > num) {
                    arr[i - 1] = num;
                } else {
                    if (i ==0 ){
                        arr[i] = arr[i];
                    }else{
                        arr[i - 1] = arr[i];
                    }
                }
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {

//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer e1, Integer e2) {
                        return e2 - e1;
                    }
                }
        );
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

}
