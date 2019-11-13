package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestRestController {
  private static final String template ="Hello, %s";
  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  @Autowired
  private   Producer producer2;

  @GetMapping("/hello-world")
  @ResponseBody
  public String sayHello(@RequestParam(name="name",required = false, defaultValue="World") String name)
  {
    logger.info("Web Method sayHello" + name);
    producer2.sendMessage("planner-test-out","this is sample message planner-test-out");
    producer2.sendMessage("planner-test","This is sample message on planner-test");
    return "greeting";
  }


}
