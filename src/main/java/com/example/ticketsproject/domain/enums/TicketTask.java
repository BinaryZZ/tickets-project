package com.example.ticketsproject.domain.enums;

public enum TicketTask {
    INSTALLATION(1),
    DEINSTALLATION(2),
    TROUBLESHOOTING(3);

    private int taskCode;

    private TicketTask(int taskCode) {
        this.taskCode = taskCode;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public static TicketTask valueOf(int taskCode) {
        for (TicketTask value : TicketTask.values()) {
            if (value.getTaskCode() == taskCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TicketStatus code;");
    }
}