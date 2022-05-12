
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class ClientHendler {
	
		//Numero della porta 
		int port = 2000;
		
    	//indirizzo del server
		InetAddress serverAddress;
	
		//socket UDP
		DatagramSocket dSocket;
		
		//Datagramma UDP con la richiesta da inviare al server
		DatagramPacket outPacket;
		
		//Datagramma UDP di risposta ricevuto dal server
		DatagramPacket inPacket;
		
		//buffer per i dati da inviare
		byte[] buffer = new byte[256];
		
		//messaggio di richiesta
		String message="RICHIESTA DATA E ORA";
		
		//messaggio di risposta
		String response;

                
 public void scrivi() throws IOException {
	 
        try 
        {
            serverAddress = InetAddress.getLocalHost();
            
            System.out.println("Indirizzo del server trovato!");
            dSocket = new DatagramSocket();
            
            //Preparo il datagramma con i dati da inviare
            outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, port);
            
            //Invio dei dati
            dSocket.send(outPacket);
            
        } catch (SocketException ex) {
            Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
public String leggi() {
        try {
            inPacket = new DatagramPacket(buffer, buffer.length);
            
            //Attendo che il datagramma arrivi
            dSocket.receive(inPacket);
            
            //Estraggo il messaggio
            response = new String(inPacket.getData(), 0, inPacket.getLength());
            
        } catch (IOException ex) {
            Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return response;
                }
                public void chiudi() {
                    dSocket.close();
                }
                        
}