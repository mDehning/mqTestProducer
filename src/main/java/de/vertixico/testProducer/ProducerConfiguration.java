package de.vertixico.testProducer;



import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.dropwizard.activemq.ActiveMQConfig;
import com.kjetland.dropwizard.activemq.ActiveMQConfigHolder;

import de.fundstech.dropwizard.auth.config.FundswareAuthConfigHolder;
import de.fundstech.dropwizard.auth.config.LoginServiceClientConfiguration;

import io.dropwizard.Configuration;


public class ProducerConfiguration extends Configuration implements FundswareAuthConfigHolder, ActiveMQConfigHolder{
	

	private LoginServiceClientConfiguration loginService;
	
	@JsonProperty
    @NotNull
    @Valid
    private ActiveMQConfig activeMQ;

    @JsonProperty
    @NotNull
    private String queueName;
    
	public LoginServiceClientConfiguration getLoginServiceClientConfiguration() {
		return loginService;
	}
	
	public void setLoginServiceClientConfiguration(LoginServiceClientConfiguration l){
		this.loginService = l;
	}

	public ActiveMQConfig getActiveMQ() {
		return activeMQ;
	}
	
	 public String getQueueName() {
	        return queueName;
	    }
}
