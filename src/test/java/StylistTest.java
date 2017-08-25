import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

	@Test
	public void stylist_instantiatesCorrectly_true() {
		Stylist testStylist = new Stylist("Best");
		assertEquals(true, testStylist instanceof Stylist);
	}

	@Test
	public void stylist_instantiatesWithName_String() {
		Stylist testStylist = new Stylist("Best");
		assertEquals("Best", testStylist.getName());
	}

	@Test
	public void getId_instantiatesWithAnId_2() {
		Stylist testStylist = new Stylist("Best");
		assertEquals(2, testStylist.getId());
	}

	@Test
	public void all_returnsAllInstancesOfStylist_true() {
		Stylist firstStylist = new Stylist("Best");
		Stylist secondStylist = new Stylist("Average");
		assertEquals(true, Stylist.all().contains(firstStylist));
		assertEquals(true, Stylist.all().contains(secondStylist));
	}

	@Test
	public void clear_emptiesAllStylistsFromList_0() {
		Stylist testStylist = new Stylist("Best");
		Stylist.clear();
		assertEquals(Stylist.all().size(), 0);
	}

	@Test
	public void find_returnsAllStylistsWithSameId_secondStylist() {
		Stylist.clear();
		Stylist firstStylist = new Stylist("Best");
		Stylist secondStylist = new Stylist("Average");
		assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
	}

	@Test
	public void getStylists_returnsEmptyList_ArrayList() {
		Stylist.clear();
		Stylist testStylist = new Stylist("Best");
		assertEquals(0, testStylist.getClients().size());
	}

	@Test
	public void addStylist_addsClientsToTheList_true() {
		Stylist testStylist = new Stylist("Best");
		Stylist testClient = new Stylist("Stylists");
		testStylist.addClient(testClient);
		assertTrue(testStylist.getClients().contains(testClient));
	}
}