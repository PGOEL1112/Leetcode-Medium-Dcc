import java.util.Arrays;
public class CountCoveredBuilding {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        int[] minr=new int[n+1];
        int[] maxr=new int[n+1];
        int[] minc=new int[n+1];
        int[] maxc=new int[n+1];
        Arrays.fill(minr,Integer.MAX_VALUE);
        Arrays.fill(minc,Integer.MAX_VALUE);
        for(int[] p:buildings){
            int x=p[0];
            int y=p[1];
            maxr[y]=Math.max(maxr[y],x);
            minr[y]=Math.min(minr[y],x);
            maxc[x]=Math.max(maxc[x],y);
            minc[x]=Math.min(minc[x],y);
        }
        int ct=0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                x > minr[y] && x < maxr[y] && y > minc[x] && y < maxc[x]
            ) {
                ct++;
            }
        }
        return ct;
    }

    public static void main(String[] args) {
        int[][] building = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        int n = 3;
        int result = countCoveredBuildings(n,building);
        System.out.println(result);
    }
}

