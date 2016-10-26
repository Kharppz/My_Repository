/* Emre BOZKURT */

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {

	private int clientNo = 0;
	private TextArea ta = new TextArea();

	@Override
	public void start (Stage primaryStage) throws Exception {
		ta.setEditable(false);

		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.show();

		new Thread( () -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8182);

				Platform.runLater( () -> {
					ta.appendText("Server started time " + new Date() + '\n');
				});

				while (true) {
					Socket socket = serverSocket.accept();
					clientNo++;

					Platform.runLater( () -> {
						ta.appendText("Starting client " + clientNo + " at " + new Date() + '\n');
						ta.appendText("Client " + clientNo + " IP Address is " + socket.getInetAddress().getHostAddress() + '\n');
					});

					new Thread(new ThreadClient(socket)).start();
				}
			} catch (Exception e) {
				ta.appendText(e.toString() + '\n');
			}
		}).start();
	}

	class ThreadClient implements Runnable {

		private Socket socket;

		public ThreadClient(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run () {
			try {
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

				while (true) {
					String normal = inputFromClient.readUTF();
					String inverse = convertInverse(normal);

					outputToClient.writeUTF(inverse);

					Platform.runLater( () -> {
						ta.appendText("Text received from client: " + normal + '\n');
						ta.appendText("Inverse is " + inverse + '\n');
					});
				}
			} catch (Exception e) {
				ta.appendText(e.toString() + '\n');
			}
		}
	}

	public String convertInverse (String normal) {
		String inverse = "";

		for (int i = normal.length() - 1; i >= 0; i--)
			inverse += normal.charAt(i);

		return inverse;
	}

	public static void main (String[] args) {
		Application.launch(args);
	}
}
