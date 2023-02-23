package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.time.LocalDateTime;

@Named
@RequestScoped
public class trade {
    private int amount;
    private int price;
    private int stockMarketID;
    private LocalDateTime createdAt;
    private int tradeID;

    public trade() {
    }

    public trade(int amount, int price, int stockMarketID, LocalDateTime createdAt, int tradeID) {
        this.amount = amount;
        this.price = price;
        this.stockMarketID = stockMarketID;
        this.createdAt = createdAt;
        this.tradeID = tradeID;
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

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }
}
