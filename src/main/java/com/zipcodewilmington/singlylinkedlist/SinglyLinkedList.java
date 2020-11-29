package com.zipcodewilmington.singlylinkedlist;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
  //new node with no data
    private static int counter;
    private Node head;

    class Node{
        int data;
        Node next;
        Node node;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

        public Node getNode(){
            return node;
        }
    }

    public SinglyLinkedList(){
    }

    public void add(Integer data) {
        if (head == null){
            head = new Node(data);
        }
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {

            //start at head and go to end to add an element there
            while (current.getNext() != null){
                current = current.getNext();
            }
            // the last node's "next" reference set to our new node
       current.setNext(temp);
        }
        incrementCounter();
        }


        private static int getCounter(){
        return counter;
        }

        private static void incrementCounter(){
        counter++;
        }

        private static void decrementCounter(){
        counter--;
        }

        public int getSize(){
        return getCounter();
        }

    // removes the element at the specified position in this list.
        public boolean remove(int index) {

            // if the index is out of range, exit
            if (index < 1 || index > getSize())
                return false;

            Node current = head;
            if (head != null) {
                for (int i = 0; i < index; i++) {
                    if (current.getNext() == null)
                        return false;

                    current = current.getNext();
                }
                current.setNext(current.getNext().getNext());

                // decrement the number of elements variable
                decrementCounter();
                return true;

            }
            return false;
        }

    public Integer get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
        return null;

    }

    public boolean contains(Integer index) {
        Node current;
        if (head != null) {
            current = head;
            if (current.getNext() != null) {
                for (int i = 0; i < getSize(); i++) {
                    if (i == current.getData()) {
                        return true;
                    }
                    current = current.getNext();
                }
            }

        }
        return false;
    }

    public Integer find(Integer index){
        Node current;
        if (head != null) {
            current = head;
            if (current.getNext() != null) {
                for (int i = 0; i < getSize(); i++) {
                    if (i == index) {
                        return i;
                    }
                    current = current.getNext();
                }
            }

        }
        return 0;
    }

    public SinglyLinkedList copyIt(){
        SinglyLinkedList copy = new SinglyLinkedList();

    }

    public void sort(){}



//    public LinkedList<> copy(){} //create new SLL - deep copying, temp node based on current node
//    public void sort(){} //integer, compare directly with bubblesort
}

//Your linked list must have a node inner class to represent each element
//Your linked list must have add, remove, contains, find, size, get, copy and sort methods
//Method definitions:
//add -- add an element to the list
//remove -- remove an element (specified by numeric index) from the list
//contains -- returns true if the element is in the list, false otherwise
//find -- returns the element's index if it is in the list, -1 otherwise
//size -- returns the current size of the list
//get -- returns the element at the specified index
//copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
//sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)