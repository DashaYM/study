package timeService;

import transactions.ColorDAO;
import transactions.Colour;

import javax.annotation.Resource;
import javax.ejb.*;

@Stateless
public class TimeServiceBean {

    @Resource
    private TimerService timerService;

    @EJB
    private ColorDAO dao;

    public void createTimer() {
        ScheduleExpression scheduleExpression = new ScheduleExpression()
                .second("0")
                .minute("0")
                .hour("0")
                .dayOfMonth("*")
                .month("*")
                .year("*")
                .dayOfWeek("*");

        TimerConfig timerConfig = new TimerConfig(null, false);
        timerService.createCalendarTimer(scheduleExpression, timerConfig);

    }

    @Timeout
    public void onTimer (Timer timer) {
        dao.persist(new Colour());
    }
}
