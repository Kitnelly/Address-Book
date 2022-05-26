import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Class for storing connections and returning ordered list of connections
public class MakeConnections {

	Collection<String> connections = new LinkedList<>();
	private String name;
	
	public MakeConnections(String name) {
		
		//this.connections = connections;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<String> getConnections() {
		LinkedList<String> list = new LinkedList<>();
		for (String str: connections) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		return list;
	}
}


