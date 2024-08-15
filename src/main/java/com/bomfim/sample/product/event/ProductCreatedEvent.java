package com.bomfim.sample.product.event;

import org.jmolecules.event.types.DomainEvent;

public record ProductCreatedEvent(Long productId) implements DomainEvent {
}
