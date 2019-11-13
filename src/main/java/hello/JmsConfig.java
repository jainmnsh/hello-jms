package hello;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

  String BROKER_URL = "tcp://messaging-dtli6qnhnk-openshift-enmasse.e785.tke-2.openshiftapps.com:443";
  String BROKER_USERNAME = "appuser";
  String BROKER_PASSWORD = "appuser-test";

  @Bean
  public ActiveMQConnectionFactory connectionFactory(){
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(BROKER_URL);
    connectionFactory.setPassword(BROKER_PASSWORD);
    connectionFactory.setUserName(BROKER_USERNAME);
    return connectionFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate(){
    JmsTemplate template = new JmsTemplate();
    template.setConnectionFactory(connectionFactory());
    return template;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency("1-1");
    return factory;
  }

}

