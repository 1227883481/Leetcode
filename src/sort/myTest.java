package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wgl
 * @create 2021-08-23 20:50
 */
public class myTest {
    Random random = new Random();
    public static void main(String[] args) {

        myTest sortTest = new myTest();
        //定义一个乱序数组
        Random rand = new Random();
        int len = 20;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(20);
//            arr[i] = i;
        }

        System.out.println("排序前："); //输出结果
        System.out.println(Arrays.toString(arr));


        long startTime = System.currentTimeMillis();

        //排序
//        sortTest.bubbleSort(arr); //冒泡排序
//        sortTest.selectSort(arr); //选择排序
//        sortTest.insertSort(arr); //插入排序
//        sortTest.quickOne(arr, 0, arr.length - 1); //快排-单路
        sortTest.quickSortTwo(arr, 0, arr.length - 1); //快排-双路
//        sortTest.quickThree(arr, 0, arr.length - 1); //快排-三路
//        sortTest.mergeSortIter(arr, 0, arr.length - 1); //归并-迭代写法
//        sortTest.mergeSort(arr, 0, arr.length - 1); //归并-递归写法
//        sortTest.HeapSort(arr);
        long endTime = System.currentTimeMillis();


        System.out.println("排序后："); //输出结果
        System.out.println(Arrays.toString(arr));

        long totalTime = endTime - startTime;
        System.out.println("用时" + totalTime + "ms");

    }

    public void quickSortTwo(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = random.nextInt(r - l + 1) + l;
        int key = arr[index];
        int start = l;
        int end = r;
        swap(arr, index, l);

        while (l < r) {
            while (l < r && arr[r] >= key) {
                r--;
            }
            while (l < r && arr[l] <= key) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, r, start);
        quickSortTwo(arr, start, r - 1);
        quickSortTwo(arr, r + 1, end);
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
