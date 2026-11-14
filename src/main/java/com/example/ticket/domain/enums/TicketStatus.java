package com.example.ticket.domain.enums;

import java.util.Set;

public enum TicketStatus {
    OPEN,
    ASSIGNED,
    PENDING,
    RESOLVED,
    CLOSED;

    // 定義每個狀態「合法的下一步」有哪些（狀態機核心白名單）
    public boolean canTransitionTo(TicketStatus nextStatus) {
        return switch (this) {
            case OPEN -> nextStatus == ASSIGNED;
            case ASSIGNED -> Set.of(PENDING, RESOLVED).contains(nextStatus);
            case PENDING -> Set.of(ASSIGNED, RESOLVED).contains(nextStatus);
            case RESOLVED -> Set.of(CLOSED, ASSIGNED).contains(nextStatus); // 7天內重開會回到 ASSIGNED
            case CLOSED -> false; // 結案後不允許任何轉移，只能開新單
        };
    }
}