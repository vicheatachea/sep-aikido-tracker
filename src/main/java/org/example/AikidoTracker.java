package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AikidoTracker {
    private List<TrainingSession> sessions = new ArrayList<>();

    public void addSession(LocalDate date, int duration) {
        sessions.add(new TrainingSession(date, duration));
    }

    public List<TrainingSession> getSessions() {
        return sessions;
    }

    public int getTotalTrainingTime() {
        return sessions.stream().mapToInt(TrainingSession::getDuration).sum();
    }

    public boolean isEligibleForKyu(LocalDate currentDate) {
        if (sessions.size() >= 100) {
            return true;
        }

        if (sessions.isEmpty()) {
            return false;
        }

        LocalDate firstSessionDate = sessions.get(0).getDate();
        long monthsBetween = ChronoUnit.MONTHS.between(firstSessionDate, currentDate);

        return monthsBetween >= 6;
    }
}