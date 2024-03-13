package bg.uni.fmi.lab01.streams.entity;

public record OrderLine(Item item, int quantity, boolean specialOffer) {
}
