
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class ServerHendler {
    	
    	DatagramSocket dSocket;
		
    	//datagramma UDP ricevuto dal client
		DatagramPacket inPacket;
		
		//datagramma UDP di risposta da inviare
		DatagramPacket outPacket;
		
		//Buffer per il contenuto del segmento da ricevere
		byte[] buffer= new byte[256];
		
		//Testo dei messaggi in I/O
		String messageIn, messageOut;
		
		//Data e ora correnti
		Date d;
                
		InetAddress clientAddress;
		int clientPort;
    
    public ServerHendler(int porta){
        try 
        {
            dSocket = new DatagramSocket(porta);
        } catch (SocketException ex) {
            Logger.getLogger(ServerHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        try {
            inPacket = new DatagramPacket(buffer, buffer.length);
            
            //Ricezione dei byte dal client che si blocca finchè no arrivano i pacchetti
            dSocket.receive(inPacket);
            
            //Recupero dell'indirizzo IP e la porta UDP del client
            InetAddress clientAddress = inPacket.getAddress();
            int clientPort = inPacket.getPort();
            
            //Stampa a video il messaggio ricevuto dal client
            messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
        } catch (IOException ex) {
            Logger.getLogger(ServerHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return messageIn;
    }
    
    public void scrivi() throws IOException{
        d = new Date();
				//Creazione del messaggio del server in uscita associandolo alla connessione aperta con il client
				messageOut = d.toString();
				
				//Creazione di un datagramma UDP in cui trasportare il messaggio di lunghezza length
				outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress , clientPort);
				
				//si invia il messaggio al client
				dSocket.send(outPacket);
    }
    
    
    
    
    
}
