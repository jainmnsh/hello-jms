package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

@Component
public class Listener {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private Producer producer;

  @JmsListener(destination = "jms/planner-queue-test")
  public void receiveMessage(final Message jsonMessage) throws JMSException {
    String messageData = null;
    System.out.println("Received message " + jsonMessage);
    if(jsonMessage instanceof TextMessage) {
      TextMessage textMessage = (TextMessage)jsonMessage;
      messageData = textMessage.getText();
      logger.debug("Message receved [{}]",messageData);
    }
    producer.sendMessage("jms/planner-test-out", messageData);
  }

}
