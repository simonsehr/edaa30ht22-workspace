package testqueue;
import queue_singlelinkedlist.FifoQueue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAppendFifoQueue {

    private FifoQueue<Integer> myIntQueue;
    private FifoQueue<Integer> myIntQueue2;
  

	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
        myIntQueue2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
        myIntQueue2 = null;
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

        for(int i = 0; i <= a; i++){
            myIntQueue.offer(i);
            myIntQueue2.offer(i + 10);
        }
        assertTrue(!myIntQueue.isEmpty() , "Queue not successful");
        assertTrue(!myIntQueue2.isEmpty() , "Queue not successful");

        myIntQueue.append(myIntQueue2);

        assertTrue(myIntQueue2.isEmpty() , "Queue2 is not empty");
        assertTrue(!myIntQueue.isEmpty() , "Queue not successful");
    }   

    @Test

    void testSize(){

        myIntQueue.offer(1);
        myIntQueue.offer(2);
        assertTrue(myIntQueue.size() == 2 && myIntQueue2.size() == 0, "Size wrong");

        myIntQueue.poll();
        myIntQueue.poll();
        myIntQueue2.offer(1);
        myIntQueue2.offer(2);
        assertTrue(myIntQueue.size() == 0 && myIntQueue2.size() == 2, "Size wrong");

        myIntQueue.offer(1);
        myIntQueue.offer(2);
        assertTrue(myIntQueue.size() == 2 && myIntQueue2.size() == 2, "Size wrong");
    } 


    @Test
	void testOnItself() {
		assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue));
        assertThrows(IllegalArgumentException.class, () -> myIntQueue2.append(myIntQueue2));

        int a = 5;
        for(int i = 1; i <= a; i++){
            myIntQueue.offer(i);
            myIntQueue2.offer(i+5);
        }

        myIntQueue.append(myIntQueue2);

        assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue));


	}
  
}
