package com.zipcodewilmington.singlylinkedlist;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    //new node with no data
    private static int counter;
    private Node head;

    class Node {
        int data;
        Node next;
        Node node;

        public Node(int data) {
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

        public Node getNode() {
            return node;
        }
    }

    public SinglyLinkedList() {
    }

    public void add(Integer data) {
        if (head == null) {
            head = new Node(data);
        }
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {

            //start at head and go to end to add an element there
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // the last node's "next" reference set to our new node
            current.setNext(temp); //set final null space with temporary info in Node temp
            //node temp becomes "next"
        }
        incrementCounter(); // does the work to get size for the getSize()
    }

    //private methods to  get/set is good not to expose field var
    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private static void decrementCounter() {
        counter--;
    }

    public int getSize() {
        return getCounter();
    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > getSize()) //1 or 0 start index?
            return false; //test add and remove sth at 0, see if breaks with index 1

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return false;
                }
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            //setting next node to the next one after it

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
        if (head != null) {
            Node current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return null;
                }
// no links when you hit null in LL, so list is over as soon as I hit null, even if it's before the index I specify
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
            for (int i = 0; i < getSize(); i++) {
                if (i == index) {
                    return true;
                    // should i == index, not current.getData()
                }
                if (current.getNext() != null) { // use this here so i don't set current
                    current = current.getNext(); // to null and get null pointer
                }
            }
        }
        return false;
    }


    public Integer find(Integer data) {
        Node current;
        if (head != null) {
            current = head;
            for (int i = 0; i < getSize(); i++) {
                if (i == data) {
                    return i;
                }
                if (current.getNext() != null) {
                    current = current.getNext();
                }
            }

        }
        return -1;
    }

    public SinglyLinkedList copyIt() {
        SinglyLinkedList copy = new SinglyLinkedList();
        // copy.add(this.head.getData()); //adding node directly would be shallow copy
        for (int i = 0; i < this.getSize(); i++) {
            //Integer data = this.get(i); This is the same as below
            copy.add(this.get(i));
        }
        return copy;
    }

    public void sort() {
        //loop thru list to know vals, approach like copy to loop thru and get with index}

//    public void sort(){} //integer, compare directly with bubblesort
    }
}


//sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)