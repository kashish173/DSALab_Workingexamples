/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB04;

/**
 *
 * @author KASHISH
 */
class Node {
    int data;
    Node address;

    public Node(int data) {
        this.data = data;
        this.address = null;
    }
}

public class LinkedList {
    Node head, tail;
    int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void add(int a) {
        Node n = new Node(a);
        if (head == null) {
            head = tail = n;
        } else {
            tail.address = n;
            tail = n;
        }
        size++;
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.address;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.print("Linked list: ");
        list.printList();
        
        System.out.println("Size of the linked list: " + list.size);
    }
}
