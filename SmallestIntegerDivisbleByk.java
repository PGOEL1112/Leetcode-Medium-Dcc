public class SmallestIntegerDivisbleByk {
    public static int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;

        int number = 1%k;
        int length = 1;

        while(number!=0){
            number = (number*10+1) % k;
            length++;
        }
        return length;
    }
    
    public static void main(String[] args) {
        int k = 3;
        int result = smallestRepunitDivByK(k);
        System.out.println("The smallest length of number is : " + result);
    }
}
