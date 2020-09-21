import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
public class Main {

	 static void main(String[] args) {
		//List<Integer> values = Collections.synchronizedList(new ArrayList());
		List<Integer> values = new ArrayList();
		//List<Integer> values = new Vector();
		new Thread(createNewAddWorker(10_000_000L, 1, values)).start();
		new Thread(createNewAddWorker(10_000_000L, 1, values)).start();
		new Thread(createNewAddWorker(10_000_000L, 1, values)).start();
		new Thread(createNewAddWorker(10_000_000L, 1, values)).start();
		System.out.println("Iniciado...");
		}
			
		private static Runnable createNewAddWorker(long howMany, Integer what, List<Integer> where) {
			return () -> {
				long adds = 0;
				for (long i = 0; i < howMany; i++) {
					adds++;
					where.add(what);
					//addSynchronized(where, what);
				}
				System.out.println("Terminei! " + where.size() + ", adi��es realizadas: " + adds);			
			};
		}

		private static void addSynchronized(List<Integer> where, Integer what) {
				synchronized (where) {
				where.add(what);		
				}
				//
			}

}
