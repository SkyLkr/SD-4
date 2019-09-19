
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/mean")
public class MeanService {
	
	@Path("{values}")
	@GET
	@Produces("application/json")
	public String getMean(@PathParam("values") PathSegment pathSegment) {
		float result = 0;
		
		MultivaluedMap<String, String> m = pathSegment.getMatrixParameters();
		for (Entry<String, List<String>> entry: m.entrySet()) {
			result += Float.parseFloat(entry.getKey());
		}
		
		return Float.toString(result / m.size());
	}
}
