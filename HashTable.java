package Hash_table1;


import java.util.ArrayList;

class Node<K,V> {
    K key;
    V value;
   Node<K,V> next;


    Node(K key,V value){
        this.key=key;
        this.value=value;
        this.next=null;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +

                '}';
    }
}

class MyLinkedHashMap<K,V>{
    final int numBuckets;
    ArrayList<LinkedList1<K>> myBucketArray;

    MyLinkedHashMap(){
        this.numBuckets=10;
        this.myBucketArray=new ArrayList<>(numBuckets);
        for (int i=0;i<numBuckets;i++){
            this.myBucketArray.add(null);
        }
    }



   int getBucketIndex(K key){
        int hashCode=Math.abs(key.hashCode());
        int index=hashCode%numBuckets;

        return index;
    }

    void add(K key ,V value){

        int index=this.getBucketIndex(key);
        LinkedList1<K> temp_list=this.myBucketArray.get(index);

        if(temp_list==null){


            temp_list=new LinkedList1<>();

            this.myBucketArray.set(index,temp_list);
            Node<K,V> newnode=new Node<K,V>(key,value);



        }


        Node<K,V> newnode=(Node<K,V> )temp_list.search(key);



        if(newnode==null){

            newnode=new Node<K,V>(key,value);
            temp_list.append(newnode);


        }
        else{
            newnode.setValue(value);

        }

    }

    public V get(K key){
        int index=this.getBucketIndex(key);

        LinkedList1<K> linkedList1=this.myBucketArray.get(index);

        if(linkedList1==null){


            return null;
        }


        Node<K,V> newnode= linkedList1.search(key);
        return (newnode==null)?null:newnode.getValue();
    }
    void remove(K key){
        int index=this.getBucketIndex(key);

           this.myBucketArray.remove(index);


    }


    void display(){
        for(LinkedList1<K> l1:myBucketArray){

            if(l1==null){
                continue;
            }
            else{
                l1.diplay();
            }
        }
    }



}
class LinkedList1<K>{



    Node head;
    Node tail;
    LinkedList1(){
        this.head=null;
        this.tail=null;
    }


    void append(Node newnode){

        if(head==null){
            head=newnode;

            return;
        }
       

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            
        }
        temp.next=newnode;


    }


    Node search(K key){
        Node temp=head;
        while (temp!=null){

            if(temp.getKey().equals(key)){

                return temp;

            }
            temp=temp.next;
        }
        return null;

    }





    public void diplay() {

        Node temp=head;

        while (temp!=null){
            System.out.println(temp.getKey()+"-"+temp.getValue());
            temp=temp.next;
        }
    }


}

public class HashTable {
    public static void main(String[] args){

        String line="To be or not to be";

        String[] arr=line.toLowerCase().split(" ");

        String line2="Paranoids are nots paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] arr1=line2.toLowerCase().split(" ");



        MyLinkedHashMap<String,Integer> linkedHashMap=new MyLinkedHashMap();




        for(String s:arr1){
            Integer val= linkedHashMap.get(s);


            if(val==null){

                val=1;
                linkedHashMap.add(s,val);



            }
            else{
                val+=1;
                linkedHashMap.add(s,val);


            }


        }
        
        linkedHashMap.display();









    }
}
