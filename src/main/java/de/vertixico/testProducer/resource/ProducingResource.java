package de.vertixico.testProducer.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kjetland.dropwizard.activemq.ActiveMQReceiver;
import com.kjetland.dropwizard.activemq.ActiveMQSender;

import de.vertixico.testProducer.dao.Apple;
import de.vertixico.testProducer.dao.Birne;

@Path("/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProducingResource {
	
	private ActiveMQSender activeMQSender;
	private static int appleCount = 0;
	
	public ProducingResource(ActiveMQSender activeMQSender){
		this.activeMQSender = activeMQSender;
	}
	private static final Logger LOG = LoggerFactory.getLogger(ProducingResource.class);
	@GET
	@Path("produce")
	public Response doProduce(){
		// ToDo: Do the producing here
		LOG.info("Producing something!");
		activeMQSender.send("Some product!");
		return Response.ok().build();
	}
	
	@GET
	@Path("produce/apple")
	public Response doProduceApple(){
		LOG.info(String.format("Producing apple No %s!", ++appleCount));
		
		activeMQSender.send(new Apple("Vertis Apfel Nr. "+appleCount, "mega rot", Apple.Sorte.lecker));
		
		return Response.ok().build();
	}
	
	@GET
	@Path("produce/birne")
	public Response doProduceBirne(){
		LOG.info("Producing a pear!");
		
		activeMQSender.send(new Birne("Vertis Birne", true, 9001));
		
		return Response.ok().build();
	}
}
