class Solution {
     public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") 
                || token.equals("*") || token.equals("/")) {

                int d2 = st.pop();
                int d1 = st.pop();
                int result = 0;

                if (token.equals("+")) {
                    result = d1 + d2;
                } 
                else if (token.equals("-")) {
                    result = d1 - d2;
                } 
                else if (token.equals("*")) {
                    result = d1 * d2;
                } 
                else { 
                    result = d1 / d2;   
                }

                st.push(result);
            } 
            else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
