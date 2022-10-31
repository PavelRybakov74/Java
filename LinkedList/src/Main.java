public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new List<>();

        for(int i = 0; i<10; i++){
            Elem<Integer> el = new Elem<>(i);
            list1.push(el);
        }

        System.out.println("List");
        list1.print();

        System.out.println("Listpop");
        list1.pop();
        list1.print();
    }

}