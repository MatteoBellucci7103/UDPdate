

/**
 *
 * @author Monica Ciuchetti
 */
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException {
		
		ClientHendler client = new ClientHendler();
			client.scrivi();
			String str = client.leggi();
            System.out.println(str);
            client.chiudi();
                          
	}

}
