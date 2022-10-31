public class Elem<T> {
    Node<T> inf;
    Elem<T> next;

    Elem(T ind)
    {
        Node<T> el = new Node<T>(ind);
        next = null;
        this.inf = el;
    }

    void print()
    {
        inf.print();
    }
}
