import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/")
public class MedianService {
	
	@Path("{values:calculate}")
	@GET
	@Produces("application/json")
	public String getMedian(@PathParam("values") PathSegment pathSegment) {
		
		MultivaluedMap<String, String> m = pathSegment.getMatrixParameters();
		ArrayList<Double> values = new ArrayList<>();
		
		for (Entry<String, List<String>> entry: m.entrySet()) {
			values.add(Double.parseDouble(entry.getKey()));
		}
		
		values.sort(null);
		
		int middle = values.size() / 2;
		
		if (values.size() % 2 == 1) {
			return values.get(middle).toString();
		} else {
			return Double.toString((values.get(middle) + values.get(middle-1))/2);
		}
	}
}
