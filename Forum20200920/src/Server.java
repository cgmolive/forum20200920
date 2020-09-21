import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	private static final int PORT = 8080;
	private int contador = 0;
	private String mensagem = "ping";
	
	public static void main(String[] args) {
		Server server = new Server();
		server.listen();
	
	}
	
	private void listen() {
		try (ServerSocket socket = new ServerSocket(PORT)) {
			while (mensagem != "END") {
				Client client = new Client(socket.accept(), new ClientHandlerListener() {
					@Override
					public void handleMessage() {
						System.out.println("Pong!");
						contador++;
					}
				});
			
				client.start();	

			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
					
			
	}
	
}
