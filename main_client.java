import java.net.*;
import java.io.*;

public class main_client {

	public main_client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	private static Socket c1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			c1 = new Socket("127.0.0.1",1030);
			System.out.println("Nawiązano połączenie\n");
			try{
				PrintWriter out = new PrintWriter(c1.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(c1.getInputStream()));
				out.println("Ping");
				if (in.readLine().equals("Pong")){
					System.out.println("Otrzymano Pong\n");
					out.println("Ping");
				}
				else{
					System.out.println("Otrzymano złe słowo");
				}
				
			}
			catch(IOException e3){
				System.out.println(e3);
			}
		}
		catch(IOException e){
			System.out.println("Nie udało się nawiązać połączenia\n");
		}
	}

}
