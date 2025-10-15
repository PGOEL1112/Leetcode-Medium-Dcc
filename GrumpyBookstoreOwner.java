public class GrumpyBookstoreOwner {
    public static int helper(int[] customer, int[] grumpy, int minutes){
        int n = customer.length;
        int unsatisfied = 0, maxunsatisfied = 0, satisfied = 0, i = 0, j = minutes-1, a = i, b = j;

        for (int k = i; k<j ; k++) {ṇ
            if(grumpy[k]==1) unsatisfied+=customer[k];
            else satisfied+=customer[k];
        }

        while(j<n){
            i++; j++;
            if(j<n && grumpy[j]==1) unsatisfied+=customer[j];
            if(grumpy[i-1]==1) unsatisfied-=customer[i-1];

            if(unsatisfied>maxunsatisfied){
                maxunsatisfied = unsatisfied;
                a = i; b = j;
            }

            for(int k=a; k<=b; k++){
                if(grumpy[k]==1) satisfied+=customer[k];
            }
        }
        return satisfied;

    }
    public static void main(String[] args) {
        int[] customer = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes =3;

        int ans = helper(customer,grupmy,minutes);
        System.out.println("THE MOST SATISFIED CUSTOMER ARE : "+ans);
    }
    
}
