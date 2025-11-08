import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void backtrack(int[] candidates, int target, int start, List<Integer> list,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(target<0) return;
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, list, res);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates , int target){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates,target);
        
        System.out.println(res);
    }
}
