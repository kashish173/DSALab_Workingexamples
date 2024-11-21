/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kashish
 */
public class LinkedList {
    private Node top;
    
    
    public static class Node {
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    
    public void insertFirst(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    
 
    public Node deleteFirst() {
        if (top == null) {
            return null; 
        }
        Node temp = top;
        top = top.next;
        return temp;
    }
    
    public void displayList() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
  
    public class LinkedListStack {
        
        LinkedList li = new LinkedList();
        
        
        public void push(int element) {
            li.insertFirst(element);
        }
        
        public void pop() {
            li.deleteFirst();
        }
        
        public void displayStack() {
            System.out.println(" ");
            li.displayList();
        }
    }

    
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedListStack st = linkedList.new LinkedListStack();
        
        st.push(50);
        st.push(60);
        st.push(190);
        
        System.out.println("1. Stack after push operations:");
        st.displayStack();
        
        st.pop(); 
        
        System.out.println("2. Stack after pop operation:");
        st.displayStack();
    }
}
