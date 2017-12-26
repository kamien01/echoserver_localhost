import java.net.*;
import java.io.*;

public class main_server {

	public main_server() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	private static ServerSocket s1=null;
	private static Socket c1=null;
	//private static PrintWriter out;
	//private static BufferedReader in;
	static boolean pingpong = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int port = 1030;
			InetAddress address= InetAddress.getByName("127.0.0.1");
			s1 = new ServerSocket(port,50,address);	//port, liczba kolejkowanych połączeń, przypisany socketowi adres IP
			//System.out.print(s1.getInetAddress());	//wyświetlanie adresu IP przypisanego do socketu
			c1=s1.accept();
			System.out.println("Nawiązano połączenie z +address+ na porcie +port+\n");
		}
		catch(IOException e2){
			System.out.println(e2);
		}
		try{
			PrintWriter out = new PrintWriter(c1.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(c1.getInputStream()));
			if (in.readLine().equals("Ping")){
				System.out.println("Otrzymano Ping\n");
				out.println("Pong");
			}
			else{
				System.out.println("Otrzymano złe słowo");
				System.out.println(in.readLine());
			}
		}
		catch(IOException e3){
			System.out.println(e3);
		}
		
	}

}
