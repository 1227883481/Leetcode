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

        int sizeOfNums = 20; //数组长度
        int rangeOfNums = 200; //数组中随机数的范围
        boolean needPrint = true; //要不要打印

        myTest sortTest = new myTest();
        //定义一个乱序数组
        Random rand = new Random();
        int len = sizeOfNums;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(rangeOfNums);
//            arr[i] = i;
        }

        System.out.println("排序前："); //输出结果
        if (needPrint) {
            System.out.println(Arrays.toString(arr));
        }


        long startTime = System.currentTimeMillis();

        //排序
//        sortTest.bubbleSort(arr); //冒泡排序
//        sortTest.selectSort(arr); //选择排序
//        sortTest.insertSort(arr); //插入排序
//        sortTest.quickOne(arr, 0, arr.length - 1); //快排-单路
        sortTest.heapSort(arr); //快排-双路
//        sortTest.quickThree(arr, 0, arr.length - 1); //快排-三路
//        sortTest.mergeSortIter(arr, 0, arr.length - 1); //归并-迭代写法
//        sortTest.mergeSort(arr, 0, arr.length - 1); //归并-递归写法
//        sortTest.HeapSort(arr);
        long endTime = System.currentTimeMillis();


        System.out.println("排序后："); //输出结果
//        System.out.println(Arrays.toString(arr));
        if (needPrint) {
            System.out.println(Arrays.toString(arr));
        }

        long totalTime = endTime - startTime;
        System.out.println("用时" + totalTime + "ms");

    }

    //归并排序默写
    public void mergeSort(int[] arr) {
        int len = arr.length;
        int size = 1;
        while (size < len) {
            for (int i = 0; i + size < len; i = i + size * 2) {
                merge(arr, i, i + size - 1, Math.min(i + size * 2 - 1, len - 1));
            }
            size = size * 2;
        }
    }
    public void merge(int[] arr, int start, int center, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int size = end - center;
        int i = start;
        int j = center + 1;
        for (; i <= center && j <= end;) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            } else {
                temp[index++] = arr[j];
                j++;
            }
        }
        while (i <= center) {
            temp[index++] = arr[i++];
        }
        while (j <= end) {
            temp[index++] = arr[j++];
        }
        index = 0;
        for (i = start; i <= end; i++) {
            arr[i] = temp[index++];
        }
    }

    //双路快排默写
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
    //交换算法
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //堆排序默写
    public void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1 - 1)/2; i >= 0; i--) {
            adjestHeap(arr, i, len - 1);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjestHeap(arr, 0, i - 1);
        }
    }
    public void adjestHeap(int[] arr, int start, int end) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int maxIndex;
        while (left <= end) {

            if (right <= end && arr[right] > arr[left]) {
                maxIndex = right;
            } else {
                maxIndex = left;
            }
            if (arr[maxIndex] > arr[start]) {
                swap(arr, maxIndex, start);
            } else {
                break;
            }
            left = 2 * maxIndex + 1;
            right = 2 * maxIndex + 2;
            start = maxIndex;
        }
    }

}
