import com.anwesh.impl.Scheduler;

public class TestScheduler {

    public static void main(String args[]) {
        Scheduler scheduler = Scheduler.getInstance();
        for(int i = 0; i < 4; i++) {
            final String text = "hello " + i;
            scheduler.schedule(() ->{
                System.out.println(text);
            }, (i + 1) * 1000);
        }
    }
}
