
package com.dgyt.code;
public class Node{

    public int value;

    public Node next;
    public static Node init(){
         Node head = new Node();
         head.value=1;
         Node second = new Node();
         head.next = second;
         second.value=2;
         Node third = new Node();
         third.value=3;
         second.next = third;
         return head;
    }
    /*
     **
   init node by a int array.
   **/
    public static Node init(int[] values){
     if(values == null || values.length==0) return null;
     Node head = new Node(); 
     Node cur = head;
     cur.value=values[0];
     for(int i= 1;i<values.length;i++){
         Node tmp = new Node();
         tmp.value=values[i];
         cur.next = tmp;
         cur = tmp;
     }
     return head;


    }
    /*
      delete by node value
      Note : head may be removed ,so we need  return value.
    */
    public static Node deleteNodeByValue(Node head,int target){
        while(head !=null){
            if(head.value != target){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while(cur != null){
          if(cur.value == target){
              pre.next = cur.next;
          }else{
            pre = cur;
          }
          
          cur = cur.next;
       }
       return head; 

    }

    public static void printNode(Node head){
	while(head!=null){
          System.out.println(head.value);
          head = head.next;
        }
   }




    public static void main(String[] args){
        Node head = Node.init(new int[]{4,5,6,8,4,4,2});
        head =Node.deleteNodeByValue(head,4);
        Node.printNode(head);
    }
   



}
