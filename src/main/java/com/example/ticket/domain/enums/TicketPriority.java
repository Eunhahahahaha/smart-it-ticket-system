package com.example.ticket.domain.enums;

import lombok.Getter;

@Getter
public enum TicketPriority {
    P1("緊急", 15, 240),
    P2("高", 60, 540),
    P3("一般", 540, 2700);

    private final String description;
    private final int responseMinutes;
    private final int resolutionMinutes;

    TicketPriority(String description, int responseMinutes, int resolutionMinutes) {
        this.description = description;
        this.responseMinutes = responseMinutes;
        this.resolutionMinutes = resolutionMinutes;
    }
}