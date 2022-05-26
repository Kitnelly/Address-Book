import java.util.*;

public class AdressBook {
	
	private Map<String, MakeConnections> address;
	
	
	AdressBook() {
		this.address = new HashMap<String, MakeConnections>();
	}
	
	//Method makes new MakeConnections class if one doesn't exist already, also finds any links that will apply to all relevant entries
	public void addConnection(MakeConnections make, String name) {
		if (!(address.get(make.getName()) == null)) {
			make.connections.add(name);
		}
		if (address.containsKey(make.getName()) && make.connections.contains(name)) {
			
		}
		if (address.containsKey(make.getName()) && !make.connections.contains(name)) {
			make.connections.add(name);
		}
		if (!address.containsKey(name)) {
			MakeConnections names = new MakeConnections(name);
			address.put(name, names);
			address.get(name).connections.add(make.getName());
			for (String entry: address.keySet()) {
				if (address.get(entry).connections.contains(make.getName())) {
					names.connections.add(make.getName());
				}
			}
		}
		if (address.containsKey(name)) {
			address.get(name).connections.add(make.getName());
			for (String entry: address.keySet()) {
				if (address.get(entry).connections.contains(make.getName())) {
					make.connections.add(entry);
				}
			}
		}
	}
	
	//Input Scanner that takes a String and returns all phone or name connections to name/number entered
	public static void main(String[] args) {
		
		AdressBook addressbook = new AdressBook();
		MakeConnections Jim = new MakeConnections("Jim");
		addressbook.address.put("Jim", Jim);
		addressbook.addConnection(Jim, "456");
		addressbook.addConnection(Jim, "356");
		addressbook.addConnection(Jim, "256");
		MakeConnections Sally = new MakeConnections("Sally");
		addressbook.address.put("Sally", Sally);
		addressbook.addConnection(Sally, "256");
		Scanner scan = new Scanner(System.in);
		System.out.println("enter a name or number (no dashes, capitalization matters)");
		String str = scan.nextLine();
		if (addressbook.address.containsKey(str)) {
			System.out.println(addressbook.address.get(str).getConnections());
			//System.out.println(addressbook.address.get("Jim").getConnections());
		} else { System.out.println("This name/number is not registered"); }
		
		
	}
}
