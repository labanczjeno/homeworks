package xyz.codingmentor.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import xyz.codingmentor.flight.FlightInfo;

/**
 *
 * @author blazefury
 */
@Stateless
public class FlightMessageBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/flightScheduleTopic")
    private Topic topic;

    public FlightMessageBean() {
        //empty on purpose
    }

    @Inject
    public FlightMessageBean(JMSContext context) {
        this.context = context;
    }

    public void messageWhenDeletedTheFlightInfo(FlightInfo flightInfo) {
        String message = flightInfo.toString() + "has been deleted, please check the website for more information.";
        proceedMessageToTopic(message);
    }

    public void messageWhenEditedTheFlightInfo(FlightInfo flightInfo) {
        String message = flightInfo.toString() + "has been modified, please check the website for more information.";
        proceedMessageToTopic(message);
    }
    
    public void proceedMessageToTopic(String message){
        context.createProducer().send(topic, message);
    }
}
