package top.atstudy.basic.suanfa.sort;


public abstract class Example {

    protected abstract void sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    protected void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a, Integer x, Integer y){
        for (int i = 0; i < a.length; i++) {
            if((x != null && i == x) || (y != null && i == y)){
                System.out.print("[" + a[i] + "] ");
            } else{
                System.out.print(" " + a[i] + "  ");
            }
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Example example = new Example() {
            @Override
            protected void sort(Comparable[] a) {

            }
        };
        String[] a = {"abc", "bed", "dd", "abc", "dd"};
        example.show(a, null, null);
        example.sort(a);
        example.isSorted(a);
        example.show(a, null, null);
    }

}
