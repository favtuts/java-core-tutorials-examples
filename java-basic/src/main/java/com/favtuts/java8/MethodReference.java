package com.favtuts.java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReference {
    
    public static void main(String[] args) {
        //demoStaticSimplePrintMethodReference();
        //demoStaticIntegerParseIntMethodReference();
        //demoStaticIntegerUtilsJoinMethodReference();

        //demoInstanceMethodObjectComparatorProvider();
        //demoInstanceMethodObjectArbitraryObject();
        //demoInstanceMethodObjectArbitraryObject2();

        //demoConstructorDefaultMethodReference();
        demoConstructorArgumentsMethodReference();
    }

    private static void demoStaticIntegerParseIntMethodReference(){
        List<String> list = Arrays.asList("1", "2", "3");

        // anonymous class
        List<Integer> collect1 = list.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .collect(Collectors.toList());
        collect1.forEach(x-> System.out.println(x));

        // lambda expression
        List<Integer> collect2 = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        collect2.forEach(x-> System.out.println(x));

        // method reference
        List<Integer> collect3 = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        collect3.forEach(x-> System.out.println(x));
    }

    private static void demoStaticSimplePrintMethodReference() {

        List<String> list = Arrays.asList("A", "B", "C");

        // anonymous class
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String x) {
                SimplePrinter.print(x);
            }
        });

        // lambda expression
        list.forEach(x -> SimplePrinter.print(x));

        // method reference
        list.forEach(SimplePrinter::print);

    }

    private static void demoStaticIntegerUtilsJoinMethodReference() {

        // anonymous class
        String result1 = playTwoArgument(1, 2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return IntegerUtils.join(a, b);
            }
        });                                                                             // 3

        // lambda
        String result2 = playTwoArgument(1, 2, (a, b) -> IntegerUtils.join(a, b));  // 3

        // method reference
        String result3 = playTwoArgument(1, 2, IntegerUtils::join);                 // 3

        System.out.println( Arrays.asList(result1, result2, result3));
    }

    private static <R> R playTwoArgument(Integer i1, Integer i2,
        BiFunction<Integer, Integer, R> func) {
        return func.apply(i1, i2);
    }

    static <R> R playOneArgument(String s1, Function<String, R> func) {
        return func.apply(s1);
    }

    static Boolean playTwoArgument(String s1, String s2, BiPredicate<String, String> func) {
        return func.test(s1, s2);
    }

    private static void demoInstanceMethodObjectComparatorProvider() {
        List<Employee> list = Arrays.asList(
                new Employee("favtuts", 38, BigDecimal.valueOf(3800)),
                new Employee("zilap", 5, BigDecimal.valueOf(100)),
                new Employee("ali", 25, BigDecimal.valueOf(2500)),
                new Employee("unknown", 99, BigDecimal.valueOf(9999)));

        // anonymous class
        /*list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return provider.compareBySalary(o1, o2);
            }
        });*/

        ComparatorProvider provider = new ComparatorProvider();

        // lambda
        // list.sort((o1, o2) -> provider.compareBySalary(o1, o2));

        // method reference
        list.sort(provider::compareBySalary);

        list.forEach(x -> System.out.println(x));
    }


    private static void demoInstanceMethodObjectArbitraryObject() {

        // lambda
        int result = playOneArgument("favtuts", x -> x.length());   // 7

        // method reference
        int result2 = playOneArgument("favtuts", String::length);   // 7

        // lambda
        Boolean result3 = playTwoArgument("favtuts", "f", (a, b) -> a.contains(b)); // true

        // method reference
        Boolean result4 = playTwoArgument("favtuts", "f", String::contains);        // true

        // lambda
        Boolean result5 = playTwoArgument("favtuts", "1", (a, b) -> a.startsWith(b)); // false

        // method reference
        Boolean result6 = playTwoArgument("favtuts", "y", String::startsWith);        // false

        System.out.println(result6);

    }


    static BigDecimal calculate(InvoiceCalculator formula, Invoice s1,
                                BiFunction<InvoiceCalculator, Invoice, BigDecimal> func) {
        return func.apply(formula, s1);
    }


    public static void demoInstanceMethodObjectArbitraryObject2() {

        Invoice obj = new Invoice("A001", BigDecimal.valueOf(1.99), 3);

        InvoiceCalculator formula = new InvoiceCalculator();

        // lambda
        BigDecimal result = calculate(formula, obj, (f, o) -> f.normal(o));         // 5.97

        // method reference
        BigDecimal result2 = calculate(formula, obj, InvoiceCalculator::normal);    // 5.97

        // lambda
        BigDecimal result3 = calculate(formula, obj, (f, o) -> f.promotion(o));     // 5.37

        // method reference
        BigDecimal result4 = calculate(formula, obj, InvoiceCalculator::promotion); // 5.37

    }

    public static void demoConstructorDefaultMethodReference() {

        // lambda
        Supplier<Map> obj1 = () -> new HashMap();   // default HashMap() constructor
        Map map1 = obj1.get();

        // method reference
        Supplier<Map> obj2 = HashMap::new;
        Map map2 = obj2.get();

        // lambda
        Supplier<Invoice> obj3 = () -> new Invoice(); // default Invoice() constructor
        Invoice invoice1 = obj3.get();

        // method reference
        Supplier<Invoice> obj4 = Invoice::new;
        Invoice invoice2 = obj4.get();

    }

    static List<Invoice> fakeInvoice(List<BigDecimal> list, Function<BigDecimal, Invoice> func) {
        List<Invoice> result = new ArrayList<>();

        for (BigDecimal amount : list) {
            result.add(func.apply(amount));
        }
        return result;
    }

    private static void demoConstructorArgumentsMethodReference() {
        List<BigDecimal> list = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(2.99),
                BigDecimal.valueOf(8.99));

        // lambda
        // List<Invoice> invoices = fakeInvoice(list, (price) -> new Invoice(price));

        // method reference
        List<Invoice> invoices = fakeInvoice(list, Invoice::new);

        invoices.forEach(System.out::println);
    }
}

class SimplePrinter {
    public static void print(String str) {
        System.out.println(str);
    }
}


class IntegerUtils{

    public static String join(Integer a, Integer b) {
        return String.valueOf(a + b);
    }

}


class ComparatorProvider {

    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

}


class InvoiceCalculator {

    public BigDecimal normal(Invoice obj) {
        return obj.getUnitPrice().multiply(BigDecimal.valueOf(obj.qty));
    }

    public BigDecimal promotion(Invoice obj) {
        return obj.getUnitPrice()
                .multiply(BigDecimal.valueOf(obj.qty))
                .multiply(BigDecimal.valueOf(0.9))
                .setScale(2, RoundingMode.HALF_UP);
    }
}