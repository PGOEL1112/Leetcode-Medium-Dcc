public class GoalParserInterpretion {
    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            
            if(ch=='G') sb.append("G");
            else if((ch=='(') && command.charAt(i+1)==')'){
                sb.append("o");
                i++;
            } 
            else if((ch=='(') &&  command.charAt(i+1)=='a'){
                sb.append("al");
                i = i + 3;

            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String command = "G()()()()(al)";;
        String result = interpret(command);
        System.out.println(result);
    }
}
