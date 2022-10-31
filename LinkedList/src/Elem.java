public class Elem<T> {
    Node<T> inf;
    Elem<T> next;

    public Elem(T ind)
    {
        Node<T> el = new Node<T>(ind);
        next = null;
        this.inf = el;
    }

    public void print()
    {
        inf.print();
    }
}
