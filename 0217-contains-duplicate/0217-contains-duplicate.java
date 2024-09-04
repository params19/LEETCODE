class Solution {
  public boolean containsDuplicate(int[] nums) {
      Set<Integer> ss=new HashSet<>();
      for(int i :nums){
          if(ss.contains(i))return true;
          ss.add(i);
      }
      return false;
    }
}