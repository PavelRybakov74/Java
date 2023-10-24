package tmData;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {

    private final Config config;
    private final Dim dim;
    private final DatXML datXML;
    private final KNP knp;

    // Все полезные Tm записи из файла tm.KNP в порядке их появления
    private final ArrayList<Tm> rezTm = new ArrayList<>();

    // Все имена параметров(полезных записей) встретившиеся в файле tm.KNP (Отсортированные и уникальные)
    private final TreeSet<String> treeSetNameParam = new TreeSet<>();

    public Controller() {
        this.config = new Config();
        this.dim = new Dim();
        this.datXML = new DatXML();
        this.knp = new KNP();
    }

    public void runApp() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Program works, wait...");
        config.run();
        dim.run(Config.inDim);
        datXML.run(Config.inDatxml);
        knp.run(Config.inTMI);
        createRezult();
        clientDialog();
    }

    private void clientDialog() {
        Scanner scanner = new Scanner(System.in);
        String word1 = "";
        String word2 = "";

        while (!word1.equals("quit") & !word2.equals("quit")) {
            System.out.println("Enter the parameter name or one of these values: all, long, double, code, point, paramNames, quit");
            word1 = scanner.next();
            switch (word1) {
                case "quit" -> System.out.println("Program finished");
                case "paramNames" -> printRezult(word1);
                case "all", "long", "double", "code", "point" -> {
                    System.out.println("Enter sort: num, name, znach, razm, time, type, 0(do not sort), quit");
                    word2 = scanner.next();
                    switch (word2) {
                        case "quit" -> System.out.println("Program finished");
                        case "0" -> printRezult(word1);
                        case "num", "name", "znach", "razm", "time", "type" -> printSortedRezult(word1, word2);
                        default -> System.out.println("Invalid input");
                    }
                }
                default -> {
                    if (treeSetNameParam.contains(word1)) {
                        String finalWord = word1;
                        rezTm.stream().filter(x->x.name.equals(finalWord)).forEach(this::print);
                    } else System.out.println("Invalid input");
                }
            }
        }
        scanner.close();
    }

    private void createRezult() {
        //Проходим по всем элементам knp.list
        knp.list.forEach((value) -> {
            Tm tm = new Tm();

            //Если KNP запись совпадает по номеру с datXML, то берем из datXML ее имя и номер
            datXML.map.forEach((key, val) -> {
                if (key.equals(value.num)) {
                    tm.num = key;
                    tm.name = val;
                }
            });

            //Если номер размерности KNP записи совпадает с номером размерности из dim, то берем из dim ее название
            dim.map.forEach((key, val) -> {
                if (key.equals(value.razm)) tm.razm = val;
            });

            //Время берем из KNP (часы:минуты:секунды:миллисекунды)
            Date date = new Date(value.time);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
            tm.time = sdf.format(date);


            //Значение берем из KNP
            switch (value.type){
                case 0 -> tm.znachL = value.znachL;
                case 1 -> tm.znachD = value.znachD;
                case 2 -> tm.znachC = value.znachC;
                case 3 -> tm.znachP = value.znachP;
            }

            //Тип берем из KNP
            tm.type = value.type;

            if (tm.name != null && tm.razm != null) {
                //Добавляем в TreeSet имя параметра, которое нам встретилось
                treeSetNameParam.add(tm.name);

                //Кладем все, что собрали, в ArrayList
                rezTm.add(tm);
            }

        });
    }

    private void printRezult(String str) {
        switch (str) {
            case "all" -> rezTm.forEach(this::print);
            case "long", "double", "code", "point" -> rezTm.stream().filter(x->x.type==getNumType(str)).forEach(this::print);
            case "paramNames" -> treeSetNameParam.forEach(System.out::println);
        }
    }

    private void printSortedRezult(String str, String sort) {
        switch (str) {
            case "all" -> rezTm.stream().sorted(getComparatorBySort(sort)).forEach(this::print);
            case "long", "double", "code", "point" -> {
                switch (sort) {
                    case "num", "name", "znach", "razm", "time" -> rezTm.stream().filter(x->x.type==getNumType(str)).sorted(getComparatorBySort(sort)).forEach(this::print);
                    case "type" -> rezTm.stream().filter(x->x.type==getNumType(str)).forEach(this::print);
                }
            }
        }
    }

    private void print(Tm tm){
        switch (tm.type){
            case 0 -> System.out.printf("%-4d %-10s %15d %-8s %-12s %-2d%n", tm.num, tm.name, tm.znachL, tm.razm, tm.time, tm.type);
            case 1 -> System.out.printf("%-4d %-10s %15.3f %-8s %-12s %-2d%n", tm.num, tm.name, tm.znachD, tm.razm, tm.time, tm.type);
            case 2 -> System.out.printf("%-4d %-10s %15d %-8s %-12s %-2d%n", tm.num, tm.name, tm.znachC, tm.razm, tm.time, tm.type);
            case 3 -> System.out.printf("%-4d %-10s %15d %-8s %-12s %-2d%n", tm.num, tm.name, tm.znachP, tm.razm, tm.time, tm.type);
        }
    }

    private int getNumType(String str){
        switch (str) {
            case "double" -> {return 1;}
            case "code" -> {return 2;}
            case "point" -> {return 3;}
            default -> {return 0;}//long
        }
    }

    private Comparator<Tm> getComparatorBySort(String sort){
        switch (sort) {
            case "name" -> {return new NameComparator();}
            case "znach" -> {return new ZnachComparator();}
            case "razm" -> {return new RazmComparator();}
            case "time" -> {return new TimeComparator();}
            case "type" -> {return new TypeComparator();}
            default -> {return new NumComparator();}//num
        }
    }
}
