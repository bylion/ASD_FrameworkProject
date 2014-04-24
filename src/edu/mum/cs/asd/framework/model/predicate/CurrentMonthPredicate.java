package edu.mum.cs.asd.framework.model.predicate;

import edu.mum.cs.asd.framework.model.Entry;
import java.util.Calendar;

public class CurrentMonthPredicate implements IPredicate<Entry> {

    private int month;
    
    public CurrentMonthPredicate(int month) {
        this.month = month;
    }
    
    @Override
    public boolean check(Entry e) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(e.getDate());
        return calendar.get(Calendar.MONTH) == month;
    }
}
