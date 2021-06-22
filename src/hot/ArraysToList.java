package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgl
 * @create 2021-06-22 11:20
 */
public class ArraysToList {
    public static void main(String[] args) {
        Integer[] intgers = new Integer[]{1,2,3,4,5};
        int[] ints = new  int[]{1,2,3,4};
        TreeNode[] treeNodes = new TreeNode[]{new TreeNode(1), new TreeNode(2), new TreeNode(3)};
        String[] strings = new String[]{"one", "two", "three", "four"};
//        ArraysToList arraysToList = new ArraysToList();

//        look(Arrays.asList(intgers));
//        look(Arrays.asList(ints));
//        look(Arrays.asList(treeNodes));
//        look(Arrays.asList(strings));

        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<TreeNode> list3 = new ArrayList<>();
//        List<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list1.add(i);
            list2.add("第" + i);
            list3.add(new TreeNode(i));
        }
//        Integer[] arr1 = (Integer[]) list1.toArray();
//        Integer[] arr11 = list1.toArray(new Integer[2]);
        System.out.println(Arrays.toString(list1.toArray(new Integer[2])));
//        String[] arr2 = (String[]) list2.toArray();
        String[] arr22 = list2.toArray(new String[2]);
        System.out.println(Arrays.toString(list2.toArray(new String[2])));
//        TreeNode[] arr3 = (TreeNode[]) list3.toArray();
        TreeNode[] arr33 = list3.toArray(new TreeNode[1]);
        System.out.println(Arrays.toString(list3.toArray(new TreeNode[1])));

    }
    public static void look(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }


}
