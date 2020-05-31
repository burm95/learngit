public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int end;
    public ArrayDeque(){
        items=(T[])new Object[8];
        front=0;
        end=1;
        size=0;
    }
    public ArrayDeque(ArrayDeque other){
        items=(T[])new Object[other.items.length];
        System.arraycopy(other.items,0,items,0,other.items.length);
        front=other.front;
        end=other.end;
        size=other.size;
    }
    public void resize(int capacity){
        T[] a=(T[])new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }
    public void addLast(T x){
        items[end]=x;
        if(end==items.length-1){
            end=0;
        }else{
            end++;
        }
        size++;
    }
    public void addFirst(T x){
        items[front]=x;
        if(front==0){
            front=items.length-1;
        }else{
            end--;
        }
        size++;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if(front==items.length){
            int p=0;
        }
        int p=front+1;
        for(int i=0;i<size;i++){
            System.out.println(items[p]);
            if(p==items.length){
                p=0;
            }else{
                p++;
            }
        }
    }
    public T removeFirst(){
        T x=items[front+1];
        front++;
        size--;
        return x;
    }
    public T removeLast(){
        T x=items[end-1];
        end--;
        size--;
        return x;
    }
    public T get(int index){
        return items[index];
    }
}
