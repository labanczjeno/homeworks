package xyz.codingmentor.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.flight.FlightInfo;
import xyz.codingmentor.message.FlightMessageBean;
import xyz.codingmentor.service.FlightService;

/**
 *
 * @author blazefury
 */
@Startup
@Singleton
public class SchedulerOfFlightsBean {

    private FlightMessageBean flightMessageBean;
    private FlightService flightService;

    public SchedulerOfFlightsBean() {
        //empty on purpose
    }

    @Inject
    public SchedulerOfFlightsBean(FlightMessageBean flightMessageBean, FlightService flightService) {
        this.flightMessageBean = flightMessageBean;
        this.flightService = flightService;
    }

    public Date generateFlightDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }

    public Date generateFlightDateInOneHour() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }

    @Schedule(hour = "*")
    public void scheduledMessageAboutFlightInfo() {
        List<FlightInfo> flightInfoList = flightService.getAllFlightInfos();
        for (FlightInfo flightInfo : flightInfoList) {
            if (generateFlightDate().before(generateFlightDateInOneHour())) {
                String flightString = flightInfo.toString() + "takes off in one hour.";
                flightMessageBean.proceedMessageToTopic(flightString);
            }
        }
    }
}
