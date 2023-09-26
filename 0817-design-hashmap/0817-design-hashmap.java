// class MyHashMap {
//     int[] ds;

//     public MyHashMap() {
//         ds = new int[1000001];
//         Arrays.fill(ds, -1);
//     }

//     public void put(int key, int val) {
//         ds[key] = val;
//     }

//     public int get(int key) {
//         return ds[key];
//     }

//     public void remove(int key) {
//         ds[key] = -1;
//     }
// }

class ListNode{
    int key, val;
    ListNode next;
    public ListNode(int key, int val, ListNode next){
        this.key = key;
        this.val = val; 
        this.next = next;
    }
}

class MyHashMap{
    static final int size = 19997;
    ListNode[] data;
    public MyHashMap(){
        this.data = new ListNode[size];
    }

    private int hash(int key){
        return key % size;
    }

    public void put(int key, int val){
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key,val, data[h]);
        data[h] = node;
    }

    public int get(int key){
        int h = hash(key);
        ListNode node = data[h];
        while(node != null){
            if(node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }
    public void remove(int key){
        int h = hash(key);
        ListNode node = data[h];
        if(node == null) return;
        if(node.key == key) data[h] = node.next;
        else{
            while(node.next != null){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        } 
    }
}