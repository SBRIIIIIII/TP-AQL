
import static org.junit.jupiter.api.Assertions.*;
import org.example.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StackTest {
    private Stack stack;
    @BeforeEach
    void Test_initialiser(){
        stack=new Stack();
        assertEquals(0,stack.size(),"la pile doit etre initaliser à 0 elements");
    }


    @Test
    void Test_Push(){
        stack.push(1);
        stack.push(11);
        stack.push(111);
        assertEquals(3,stack.size(),"la pile doit contient 3 elements");
    }
    @Test
    void Test_pop(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int dernier =stack.pop();
        assertEquals(3,dernier," pop doit retourner le dernier element de la pile");
        assertEquals(2,stack.size(),"la taille de la pile aprés pop doit etre diminuée par 1");
    }

    @Test
    void Test_peek(){
        stack.push(1);
        stack.push(5);
        stack.push(-10);

        int dernier =stack.peek();
        assertEquals(-10,dernier,"peek doit retourner le dernier element de la pile");
        assertEquals(3,stack.size(),"peek ne retire pas l'element retourner ,la taille est inchangeable");
    }

}
