import java.util.stream.Stream;

public class SampleClass {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("guru","prasad","pandey");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
    }
}
