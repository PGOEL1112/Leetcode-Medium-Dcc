public class MaximumOperationsToMove {
    public static int maxOperations(String s) {
        char[] ch = s.toCharArray();
        int Operations = 0;
        int ones = 0;

        for (int i = 0; i < ch.length; i++) {
                if(ch[i]== '1') ones++;
                else{
                    if(i==ch.length-1 || ch[i+1]=='1')
                    Operations+=ones;
                }
        }
        
        return Operations;
    }
    public static void main(String[] args) {
        String s = "11101101";
        int result = maxOperations(s); 
        System.out.println(result);
    }
}
