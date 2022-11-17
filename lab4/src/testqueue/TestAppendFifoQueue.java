package testqueue;
import queue_singlelinkedlist.FifoQueue;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class TestAppendFifoQueue {

    private FifoQueue<Integer> myIntQueue;
    private FifoQueue<Integer> myIntQueue2;
	private FifoQueue<String> myStringQueue;
  

	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
        myIntQueue2 = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
        myIntQueue2 = null;
		myStringQueue = null;
	}

    //Tester
    @Test
    void testTwoEmpty() {
        assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue2));
    }

    @Test
    void testFirstQueueEmpty(){
        int a = 10;
        for(int i = 0; i < a; i++){
            myIntQueue2.offer(i);
        }
        assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue2));
    }
    @Test
    void testSecondQueueEmpty(){
        int a = 10;
        for(int i = 0; i < a; i++){
            myIntQueue.offer(i);
        }
        assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue2));
    }

    @Test 
    void testNoQueueEmpty(){

        int a = 10;
        int b = 20;
        for(int i = 0; i <= a; i++){
            myIntQueue.offer(i);
        }
        for(int i = 11; i <= b; i++){
            myIntQueue2.offer(i);
        }
        myIntQueue.append(myIntQueue2);
        Iterator<Integer> itr = myIntQueue.iterator();

        for (int i = 1; i <= b; i++) {
            int r = itr.next();
            System.out.println(r);
            assertEquals(Integer.valueOf(i), r, "Wrong result from next");
        }

        assertTrue(myIntQueue2.isEmpty(), "Queue successful");

    }

   
    
}
