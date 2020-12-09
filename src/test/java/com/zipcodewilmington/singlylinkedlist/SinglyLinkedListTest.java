package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Integer node1 ;
       Integer node2 ;
//        String node3;
        @Before
        public void startup() {
            node1 = 7;
          node2 = 10;
//            node3 = "Node3";
        }
        @Test
        public void addTest() {
            //Given
            //When
            singlyLinkedList.add(node1);
            singlyLinkedList.add(node2);
//            singlyLinkedList.add(node3);
            //Then
            Assert.assertEquals(node1, singlyLinkedList.get(0));
//            Assert.assertEquals(node2, singlyLinkedList.get(1));
//            Assert.assertEquals(node3, singlyLinkedList.get(2));
        }


    }
