package lab12;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BasicConcurrentHashMapDemo {

    public static void main(String[] args) throws InterruptedException {

        Map<Integer, String> map = new ConcurrentHashMap<>();

        // Writer thread: puts 100 entries into the map
        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                map.put(i, "Value-" + i);
                System.out.println("Put: " + i + " → " + map.get(i));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
            }
        });

        // Reader thread: repeatedly reads keys
        Thread reader = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                String value = map.get(i);
                System.out.println("Get: " + i + " → " + value);

                try {
                    Thread.sleep(15);
                } catch (InterruptedException ignored) {
                }
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("Final map size: " + map.size());
    }
}

