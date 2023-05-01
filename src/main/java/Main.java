import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<String> destinations = List.of("127.0.0.2", "127.0.0.3", "127.0.0.4");
        Destination d1 = new Destination(destinations.get(0), 1001, destinations.get(1), 1002);
        Destination d2 = new Destination(destinations.get(1), 1002, destinations.get(2), 1003);
        Destination d3 = new Destination(destinations.get(2), 1003, null, null);

        Sender sender = new Sender(1001, destinations);

        d1.start();
        d2.start();
        d3.start();

        sender.start();
    }
}
