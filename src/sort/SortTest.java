package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wgl
 * @create 2021-05-27 1:00
 */
public class SortTest {
    Random random = new Random();
    public static void main(String[] args) {

        int sizeOfNums = 20; //数组长度
        int rangeOfNums = 20; //数组中随机数的范围
        boolean needPrint = true; //要不要打印

        SortTest sortTest = new SortTest();
        //定义一个乱序数组
        Random rand = new Random();
        int len = 20;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(20);
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
        sortTest.quickTwo(arr, 0, arr.length - 1); //快排-双路
//        sortTest.quickThree(arr, 0, arr.length - 1); //快排-三路
//        sortTest.mergeSortIter(arr, 0, arr.length - 1); //归并-迭代写法
//        sortTest.mergeSort(arr, 0, arr.length - 1); //归并-递归写法
//        sortTest.HeapSort(arr);
        long endTime = System.currentTimeMillis();


        System.out.println("排序后："); //输出结果
        if (needPrint) {
            System.out.println(Arrays.toString(arr));
        }

        long totalTime = endTime - startTime;
        System.out.println("用时" + totalTime + "ms");

    }

    //（已废弃）快速排序，选择第一个值为基准
    public void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int index = random.nextInt(end - start + 1) + start;
        swap(arr, start, index);
        int key = arr[start];
        index = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < key) {
                swap(arr, ++index, i);
            }
        }
        swap(arr, start, index);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

//    （已废弃）快排CSDN
    public static void quickCSDN(int[] nums, int l, int r){
        if(l >= r) return;
        int i = l, j = r;
        int key = nums[l];
        while(i < j){
            while(i < j && nums[j] >= key) j--;
            while(i < j && nums[i] <= key) i++;
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        System.out.println(i + " " + j);
        nums[l] = nums[i];
        nums[i] = key;
        quickCSDN(nums, l, j - 1);
        quickCSDN(nums, j + 1, r);
    }


    //（已废弃）快速排序，选择双路排序
    public void quickTTTWO(int[] arr, int start, int end) {
        int l = start;
        int r = end;
        if (start >= end) {
            return;
        }
        int index = random.nextInt(end - start + 1) + start;
        swap(arr, index, start);
        index = start;
        int key = arr[index];
        while (l < r) {
            while (l <= r && arr[r] >= key) {
                r--;
            }
            while (l <= r && arr[l] <= key) {
                l++;
            }
//            while (l <= r && arr[l] <= key) {
//                l++;
//            }
            if (l >= r) {
                break;
            }
            swap(arr, l, r);
            l++;
            r--;
        }

//        System.out.println(" " + arr[start] +" " + arr[l] + " "  + arr[r]);

        swap(arr, start, r);
        quickTTTWO(arr, start, r - 1);
        quickTTTWO(arr, l, end);

//        swap(arr, start, r - 1);
//        quickTwo(arr, start, r - 2);
//        quickTwo(arr, l, end);

//        if (arr[start] >= arr[l]) {
//            swap(arr, start, r);
//            quickTwo(arr, start, r - 1);
//            quickTwo(arr, l + 1, end);
//        } else {
//            swap(arr, start, r - 1);
//            quickTwo(arr, start, r - 2);
//            quickTwo(arr, l, end);
//        }

    }


    //插入排序:最差的情况O(n^2)，最差的情况O(n)
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j > 0 && arr[j] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    //选择排序
    public void selectSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = i;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[temp]) {
                    temp = j;
                }
            }
            swap(arr, temp, i);
        }
    }

    //冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }

    }
    //交换元素
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快排-双路
    public void quickTwo(int[] arr, int start, int end) {
        if (end <= start) return;
        int index = random.nextInt(end - start + 1) + start;
        swap(arr, index, start);
        index = start;
        int key = arr[index];
        swap(arr, start, index);
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && arr[r] >= key) r--;
            while (l < r && arr[l] <= key) l++;
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, r, start);
        quickTwo(arr, r + 1, end);
        quickTwo(arr, start, r - 1);
    }

    //快排-单路
    public void quickOne(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
//        int index = random.nextInt(end - start + 1) + start;
        int index = start;
        swap(arr, index, start);
        int key = arr[start];
        index = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < key) {
                swap(arr, i, ++index);
            }
        }
        swap(arr, start, index);
        quickOne(arr, start, index - 1);
        quickOne(arr, index + 1, end);
    }

    //快排-三路
    public void quickThree(int[] arr, int start, int end) {
        if (end <= start) return;

        int key = arr[end];
        int lt = start - 1;
        int gt = end;
        int i = start;
        while (i < gt) {
            if (arr[i] < key) {
                swap(arr, ++lt, i);
                i++;
            } else if (arr[i] > key) {
                swap(arr, --gt, i);
            } else {
                i++;
            }
        }
        swap(arr, i, end);
        quickThree(arr, start, lt);
        quickThree(arr, gt, end);
    }
    //归并排序-递归
    public void mergeSort (int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int center = (end + start) / 2;
        mergeSort(arr, start, center);
        mergeSort(arr, center+1, end);
        merge(arr, start, center, end);
    }
    public void merge(int[] arr, int start, int center, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int l = start;
        int r = center + 1;
        while(l <= center && r <= end) {
            if (arr[l] <= arr[r]) {
                temp[index] = arr[l];
                l++;
                index++;
            } else {
                temp[index] = arr[r];
                index++;
                r++;
            }
        }
        while(l <= center) {
            temp[index++] = arr[l++];
        }
        while (r <= end) {
            temp[index++] = arr[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[start++] = temp[i];
        }

    }

    //归并排序-非递归
    public void mergeSortIter (int[] arr) {
        int i = 1;
        while (i < arr.length) {
            for (int j = 0; j + i < arr.length; j += 2*i) { //这里j + i < len而不是 j < len是为了不让最后多余的1项（比如9个数的时候）一直参与循环。
                merge(arr, j, j + i - 1, Math.min(j + 2*i - 1, arr.length - 1));
            }
            i = i*2;
        }
    }

    //堆排序
    public void HeapSort (int[] arr) {
        int len = arr.length;
        for (int i = (len - 2) / 2; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        for (int i = 0; i < len; i++) {
            swap(arr, 0, len - 1 - i);
            heapAdjust(arr, 0, len - i - 1);
        }
    }
    public void heapAdjust (int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            // 判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if ( right < size && arr[left] < arr[right]) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            // 比较父节点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
                // 如果父节点索引已经是最大值的索引，则已经是大顶堆了，则退出循环
                break;
            }
            // 父节点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            // 将索引指向孩子中较大的值的索引
            index = largestIndex;
            // 重新计算交换之后的孩子的索引；
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    //希尔排序

}
