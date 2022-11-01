public class List<T> {
    private Elem<T> head;
    private int count;

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

    public T pop()
    {
        Elem<T> temp = head;
        if (head != null)
        {
            head = temp.next;
            count--;
        }
        return temp.inf.i;
    }

    public boolean isEmpty()
    {
        return head==null;
    }

    public void clear()
    {
        while(head!=null)
        {
            pop();
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