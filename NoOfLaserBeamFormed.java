import java.util.HashMap;

public class NoOfLaserBeamFormed {
    public int numberOfBeams(String[] bank) {
        int prev =0; int totalbeam =0;

        for(String row : bank){
            int count =0; 
            for(char c : row.toCharArray()){
                if(c=='1') count++;
            }

            if(count>0) {
                totalbeam += prev*count;
                prev = count;
            }
        }
        return totalbeam;

    }

    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};
        NoOfLaserBeamFormed obj = new NoOfLaserBeamFormed();
        int ans = obj.numberOfBeams(bank);
        System.out.println(ans);

    }
    
}
