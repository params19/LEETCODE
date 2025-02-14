class ProductOfNumbers {
    // ProductOfNumbers productOfNumbers;
    ArrayList<Integer> ll;
    public ProductOfNumbers() {
        // productOfNumbers = new ProductOfNumbers();
        ll=new ArrayList<>();
    }
    
    public void add(int num) {
        ll.add(num);
    }
    
    public int getProduct(int k) {
        int add=k;
        int pro=1;
        int n=ll.size();
        int i=ll.size()-1;
        while(k-->0)
        {
            pro*=ll.get(i);
            i--;
        }
        // ll.add(add);
        return pro;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */