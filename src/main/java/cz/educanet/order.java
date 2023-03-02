package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;
@Named
@RequestScoped
public class order {
    private int orderDirection;
    private int amount;
    private int price;
    private int stockMarketID;
    private LocalDateTime createdAt;
    private int orderID;

    public order() {
    }

    public order(int orderDirection, int amount, int price, int stockMarketID, LocalDateTime createdAt, int orderID) {
        this.orderDirection = orderDirection;
        this.amount = amount;
        this.price = price;
        this.stockMarketID = stockMarketID;
        this.createdAt = createdAt;
        this.orderID = orderID;
    }

    public int getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(int orderDirection) {
        this.orderDirection = orderDirection;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockMarketID() {
        return stockMarketID;
    }

    public void setStockMarketID(int stockMarketID) {
        this.stockMarketID = stockMarketID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
