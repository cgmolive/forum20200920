import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	private Socket socket;

	private String mensagem;
	private ClientHandlerListener listener;
	
	public Client (Socket socket, ClientHandlerListener listener) {
		this.socket = socket;
		this.listener = listener;
		handleClientCommunication();
	}

	private void handleClientCommunication() {
		
			try (PrintWriter output = new PrintWriter(socket.getOutputStream());
					Scanner input = new Scanner(socket.getInputStream());){
				while (true) {
					String command = mensagem;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	private void handleMessage(String command, String body) {
		if(command.equalsIgnoreCase("ping")) {
			System.out.println("Pong!");
		}
		else if(command.equalsIgnoreCase("END")){
			mensagem = "END";
		}
	}
	
}
