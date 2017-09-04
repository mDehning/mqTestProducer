package de.vertixico.testProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kjetland.dropwizard.activemq.ActiveMQBundle;
import com.kjetland.dropwizard.activemq.ActiveMQSender;

import de.fundstech.dropwizard.auth.FundswareAuthBundle;
import de.vertixico.testProducer.resource.ProducingResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyProducer extends Application<ProducerConfiguration>{
	private static final Logger LOG = LoggerFactory.getLogger("Producer");
	
	private ActiveMQBundle activeMQBundle;
	private String queueName;
	
	public static void main(String[] args) throws Exception{
		new MyProducer().run(args);
	}
	@Override
	public void run(ProducerConfiguration configuration, Environment environment) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("Starting the Producer...");
		
		queueName = configuration.getQueueName();
		ActiveMQSender sender = activeMQBundle.createSender(queueName, true);
		ProducingResource producer = new ProducingResource(sender);
		
		environment.jersey().register(producer);
		
	}
	
	@Override
	public void initialize(Bootstrap<ProducerConfiguration> bootstrap){
		
		//	 Authentification Bundle
		bootstrap.addBundle(new FundswareAuthBundle());
		
		// Enable variable substitution with environment variables:
		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
		
		// Messaging:
		this.activeMQBundle = new ActiveMQBundle();
		bootstrap.addBundle(activeMQBundle);
		
	}
}
