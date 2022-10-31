public class List<T> {
    Elem<T> head;
    int count;

    public List()
    {
        head = null;
        count = 0;
    }

    public void push(Elem<T> el)
    {
        el.next = head;
        head = el;
        count++;
    }

    public void pop()
    {
        Elem<T> temp = head;
        if (head != null)
        {
            head = temp.next;
            count--;
        }
    }

    public void print()
    {
        Elem<T> temp = head;
        while(temp!=null)
        {
            temp.inf.print();
            temp = temp.next;
        }
        System.out.println();
    }
}