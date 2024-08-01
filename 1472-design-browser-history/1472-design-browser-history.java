class Node{
    String page;
    Node next;
    Node prev;

    public Node(String page){
        this.page = page;
        this.next = null;
        this.prev = null;
    }
}
class BrowserHistory {
    Node currentPage;

    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = newPage;
    }
    
    public String back(int steps) {
        Node temp = currentPage;
        while(steps > 0 && temp.prev != null){
            temp = temp.prev;
            steps--;
        }
        currentPage = temp;
        return temp.page;
    }
    
    public String forward(int steps) {
        Node temp = currentPage;
        while(steps > 0 && temp.next != null){
            temp = temp.next;
            steps--;
        }
        currentPage = temp;
        return temp.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */