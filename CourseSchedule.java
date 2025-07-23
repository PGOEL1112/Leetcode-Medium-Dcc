import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n ; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i=0;i<pre.length;i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                vis[i]=true;
            }
        }

        while(q.size()>0){
            int curr = q.remove();
            ans.add(curr);
            for(int ele : adj.get(curr)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
        return (ans.size()==n);
    }
}
}
