public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list1 = new LinkedList<>();

        for(int i = 0; i<10; i++){
            Elem<Integer> el = new Elem<>(i);
            list1.push(el);
        }

        System.out.println("List");
        list1.print();

        System.out.println("Listpop");
        list1.pop();
        list1.print();

        System.out.println("isEmpty " + list1.isEmpty());

        System.out.println("clear");
        list1.clear();

        System.out.println("isEmpty " + list1.isEmpty());
    }
}