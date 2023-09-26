class MyHashMap {
    int[] ds;
    public MyHashMap() {
        ds = new int[1000001];
        Arrays.fill(ds, -1);
    }
    public void put(int key, int val) {
        ds[key] = val;
    }
    public int get(int key) {
        return ds[key];
    }
    public void remove(int key) {
        ds[key] = -1;
    }
}