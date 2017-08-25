import java.util.ArrayList;

public class Client {
	private String mName;
	private int mId;
	private static ArrayList<Client> instances = new ArrayList<Client>();

	public Client(String name) {
		mName= name;
		instances.add(this);
		mId = instances.size();
	}

	public String getName() {
		return mName;
	}

	public int getId() {
		return mId;
	}

	public static ArrayList<Client> all() {
		return instances;
	}

	public static void clear() {
		instances.clear();
	}

	public static Client find(int id) {
		return instances.get(id - 1);
	}
}