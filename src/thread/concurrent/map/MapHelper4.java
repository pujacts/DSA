package thread.concurrent.map;

import java.util.Map;

public class MapHelper4 implements Runnable{
    Map<String, Integer> map;

    public MapHelper4(Map<String, Integer> map) {
        this.map = map;

        new Thread(this, "MapHelper4").start();
    }

    @Override
    public void run() {
        map.put("four", 4);
        try {
            System.out.println("MapHelper4 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
