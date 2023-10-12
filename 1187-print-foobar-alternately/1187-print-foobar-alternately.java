class FooBar {
    private int n;
    boolean printed;


    public FooBar(int n) {
        this.n = n;
        printed = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
 
        for (int i = 0; i < n; i++) {
        	synchronized(this){
                while(printed == true) wait();
                printFoo.run();
                printed = true;
                notify();
            }            
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
       
        for (int i = 0; i < n; i++) {
           synchronized(this){
               while(printed == false) wait();
               	printBar.run();
                printed = false;
                notify();
           }            
        }
    }
}