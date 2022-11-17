public class Elem<T> {
    Node <T> inf;
    Elem <T> next;

    public Elem(T in)
    {
        Node<T> el = new Node<>(in);
        next = null;
        this.inf = el;
    }

    public void print()
    {
        inf.print();
    }
}
