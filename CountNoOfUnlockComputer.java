public class CountNoOfUnlockComputer {
    static final int MOD = 1_000_000_007;
    public static int countPermutations(int[] complexity) {
        int n = complexity.length;
        int first = complexity[0];

        for(int i=1; i<n; i++){
            if(complexity[i]<=first) return 0;
        }

        long  fact = 1;
        for(int i=2; i<n; i++){
            fact = (fact*i) % MOD;
        }

        return (int)fact;
    }
    public static void main(String[] args) {
        int[] complexity = {3,4,5,6};
        int result =countPermutations(complexity);
        System.out.println(result);
    }
}
