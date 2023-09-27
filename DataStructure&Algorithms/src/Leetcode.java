import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Leetcode {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = {1,2,3};
        subsets(arr, list);
        System.out.println(list);
    }
    public static List<List<Integer>> subsets(int[] nums, List<List<Integer>> list) {
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
