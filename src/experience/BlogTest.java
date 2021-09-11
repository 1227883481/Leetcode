package experience;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgl
 * @create 2021-09-03 23:34
 */
public class BlogTest {
    public static void main(String args[]){
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        Arrays.sort(arr, new Comparator<Object>(){
            public int compare(Object arg0,Object arg1){
                Integer a=(Integer)arg0;
                Integer b=(Integer)arg1;
//                int temp=Integer.compare(a,b);
                return b - a;
            }
        });
        for(int a: arr){
            System.out.println(a+"\t");
        }
    }

}
