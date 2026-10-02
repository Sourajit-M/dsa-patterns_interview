package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class TwoDepthParenthesis {
    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int res[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int bal = 0;

        for(int i=0; i<n; i++){
            char ch = seq.charAt(i);

            if(ch == '('){
                stack.push(i);
                bal++;
            }else{
                bal--;
                int idx = stack.pop();
                res[idx] = bal;
                res[i] = bal;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "((()))";
        System.out.println(Arrays.toString(maxDepthAfterSplit(s)));
    }
}
