package hello;

import java.io.IOException;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.JMSException;


@SpringBootApplication
@EnableJms
public class Application {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception
  {
    //LocalDateTime startTime = LocalDateTime.now();
    logger.info("Main Application start [{}]");
    SpringApplication.run(Application.class,args);

    //new Application().Start();
    //SpringApplication.run(Application.class,args);
  //  LocalDateTime endTime = LocalDateTime.now();

    logger.info("Main application end [{}]");
  //  new Application().start();
  }
  public void start(){



  }
//  public void Start() throws  Exception
//  {
//    logger.info("Starting application now");
//    initialize();
//
//    jmsClient.message();
//  }
//
//  private void setDefaultExceptionHandler() {
//    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//      public void uncaughtException(Thread t, Throwable e) {
//        logger.error("Uncaught Exception in thread [{}]", t.getName(), e);
//        System.exit(1);  //exception
//      }
//    });
//  }
//  private void initialize() throws JMSException, IOException {
//    logger.debug("Starting the initialize process");
//    setDefaultExceptionHandler();
//    //commandLine = cli;
//    logger.debug("Creating JMS");
//    jmsClient = new JmsQueueClient();
//    jmsClient.connect();
//    logger.debug("Connected to JMS");
//    logger.debug("Creating rest client");
//
//    // logger.debug("Creating JMX");
//    // jmxClient = new JMXServiceClient(commandLine.getJmsClientConfiguration());
//    // jmxClient.connect();
//    // logger.debug("Connected to JMX");
//  }
}
