public class LinkedListDeque<T> {
    public class Deque {
        public T item;
        public Deque next;
        public Deque pre;
        public Deque(T i, Deque p, Deque n) {
            item = i;
            next = n;
            pre=p;
        }
    }
    private Deque sentinel;
    int size;
    public LinkedListDeque (){
        sentinel =new Deque(null,null,null);
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
    }
    public LinkedListDeque (T item){
        sentinel = new Deque(item,null,null);
        sentinel.next= new Deque(item,sentinel,sentinel);
        sentinel.pre=sentinel.next;
        size=1;
    }
    public LinkedListDeque (LinkedListDeque other){
        sentinel =new Deque(null,null,null);
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
        for(int i=0;i<other.size();i++){
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item){
        sentinel.next=new Deque(item,sentinel,sentinel.next);
        sentinel.next.next.pre=sentinel.next;
        size=size+1;
    }
    public void addLast(T item){
        sentinel.pre=new Deque(item,sentinel.pre,sentinel);
        sentinel.pre.pre.next=sentinel.pre;

        size++;
    }
    public T removeFirst(){
        Deque x=sentinel.next;
        sentinel.next=sentinel.next.next;
        sentinel.next.pre=sentinel;
        size--;
        return x.item;
    }
    public T removeLast(){
        Deque x=sentinel.pre;
        sentinel.pre=sentinel.pre.pre;
        sentinel.pre.next=sentinel;
        size--;
        return x.item;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Deque q=sentinel.next;
        while(q!=sentinel){
            System.out.println(q.item);
            q=q.next;
        }
    }
    public T get(int index){
        Deque p=sentinel;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return p.item;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

}
