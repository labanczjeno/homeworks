package xyz.codingmentor.message;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author blazefury
 */
@MessageDriven(mappedName = "jms/flightScheduleTopic")
public class FlightMessageConsumerBean implements MessageListener {

    private static final Logger LOG = Logger.getLogger(FlightMessageConsumerBean.class.getName());

    public FlightMessageConsumerBean() {
        //empty on purpose
    }

    @Override
    public void onMessage(Message message) {
        try {
            LOG.log(Level.INFO,"Recieved message: " + message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(FlightMessageConsumerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
