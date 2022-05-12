


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class Server{

	public static void main(String[] args) throws IOException{
		
		ServerHendler server= new ServerHendler(2000);
                while(true){
                    server.leggi();
                    server.scrivi();
                }
		
	}

}