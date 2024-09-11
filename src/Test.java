import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
	public static void main(String[] args) {

		Timer t = new Timer();

		TimerTask tt = new TimerTask() {

			@Override
			public void run() {

				System.out.println("main method is executing");

			};
		};

		t.schedule(tt, new Date(),2000);
	}
}