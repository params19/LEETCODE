import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        return backtrack(expression, 0, expression.length() - 1, res);
    }
    private List<Integer> backtrack(String expression, int start, int end, List<Integer> res) {
        List<Integer> result = new ArrayList<>();
        int len=end-start+1;
        if(len<=2) {
            return Arrays.asList(Integer.parseInt(expression.substring(start, end+1)));
        }
        for(int i=start; i<=end; i++) {
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*') {
                List<Integer> left = backtrack(expression, start, i-1, res);
                List<Integer> right = backtrack(expression, i+1, end, res);
                for(int l : left) {
                    for(int r : right) {
                        if(c=='+') {
                            result.add(l+r);
                        } else if(c=='-') {
                            result.add(l-r);
                        } else {
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        return result;
    }

}