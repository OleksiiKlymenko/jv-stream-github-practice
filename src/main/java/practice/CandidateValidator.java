package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String UA_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return getPeriodsInUkr(candidate.getPeriodsInUkr()) >= MIN_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(UA_NATIONALITY);
    }

    private int getPeriodsInUkr(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        return Integer.parseInt(periods[SECOND_INDEX]) - Integer.parseInt(periods[FIRST_INDEX]);
    }
}
