import java.util.Arrays;

public class CountUncountedCellsInGrid {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Storinng -1 for walls
        // Storing 1 for Guards
        // Storing 0 for nonGuards
        int[][] vis = new int[m][n];
        
        for(int[] wall : walls)   vis[wall[0]][wall[1]] = -1;
        for(int[] guard : guards) vis[guard[0]][guard[1]] = 1;


        for(int[] val : guards){
            int r = val[0] , c = val[1];

            //  Right call
            for(int i=r+1;i<m;i++){
                if(vis[i][c]==-1||vis[i][c]==1) break;
                vis[i][c] = 2;
            }

            // Left call
            for(int i=r-1;i>=0;i--){
                if(vis[i][c]==-1||vis[i][c]==1) break;
                vis[i][c] = 2;
            }

            // Down call
            for(int i=c+1;i<n;i++){
                if(vis[r][i]==-1||vis[r][i]==1) break;
                vis[r][i] = 2;
            }

            // Top call
            for(int i=c-1;i>=0;i--){
                if(vis[r][i]==-1||vis[r][i]==1) break;
                vis[r][i] = 2;
            }
        }

        int ans=0;
        for(int i=0;i<m;i++)for(int j=0;j<n;j++)if(vis[i][j]==0)ans++;
        return ans;
    }
    public static void main(String[] args) {
        int[][] guard = {{0,0}, {1,1}, {2,3}};
        int[][] walls = {{0,1}, {2,2}, {1,4}};
        int m = 4;
        int n = 6;

        int result = countUnguarded(m, n, guard, walls);
        System.out.println(result);
    }
    
}
