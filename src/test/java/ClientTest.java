import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

	@Test
	public void client_instantiateCorrectly_true() {
		Client myClient = new Client("Zahra");
		assertEquals(true, myClient instanceof Client);
	}

	@Test
	public void all_returnsAllInstancesOfClients_true() {
		Client firstClient = new Client("Zahra");
		Client secondClient = new Client("Ariana");
		assertEquals(true, Client.all().contains(firstClient));
	    assertEquals(true, Client.all().contains(secondClient));		
	}

	@Test
	public void getId_clientsInstantiateWithAnId_1() {
		Client.clear();
		Client myClient = new Client("Zahra");
		assertEquals(1, myClient.getId());
	}

	@Test
	public void find_returnsClientsWithSameId_secondClient() {
		Client firstClient = new Client("Zahra");
		Client secondClient = new Client("Ariana");
		assertEquals(Client.find(secondClient.getId()), secondClient);
	}
}