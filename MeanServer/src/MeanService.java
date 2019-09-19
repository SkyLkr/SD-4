
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/")
public class MeanService {
	
	@Path("{values:calculate}")
	@GET
	@Produces("application/json")
	public String getMean(@PathParam("values") PathSegment pathSegment) {
		double result = 0;
		
		MultivaluedMap<String, String> m = pathSegment.getMatrixParameters();
		for (Entry<String, List<String>> entry: m.entrySet()) {
			result += Double.parseDouble(entry.getKey());
		}
		
		return Double.toString(result / m.size());
	}
}
