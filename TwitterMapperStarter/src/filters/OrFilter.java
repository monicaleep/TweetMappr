package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

public class OrFilter implements Filter {
    private final Filter ch1;
    private final Filter ch2;

    public OrFilter(Filter ch1, Filter ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    @Override
    public boolean matches(Status s) {
        return ch1.matches(s) || ch2.matches(s);
    }

    @Override
    public List<String> terms() {
        List<String> newList = new ArrayList<>();
        newList.addAll(ch2.terms());
        newList.addAll(ch1.terms());
        return newList;
    }

    public String toString(){
        return "(" + ch1.toString() + " or " + ch2.toString() + ")";
    }
}
