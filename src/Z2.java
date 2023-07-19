import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */


public class Z2 {
    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод элемента:");
        enqueue(ls, sc.nextInt());
        System.out.println(ls);
        System.out.println(dequeue(ls));
        System.out.println(ls);
        System.out.println(first(ls));
        System.out.println(ls);
        sc.close();
    }
    public static void enqueue(LinkedList<Integer> ls, int element){
        ls.add(element);
    }
    public static int dequeue(LinkedList<Integer> ls){
        int a = ls.getFirst();
        ls.removeFirst();
        return a;

    }
    public static int first(LinkedList<Integer> ls){
        return ls.getFirst();
    }
}