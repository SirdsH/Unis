package cz.educanet;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class StockMarket {

    public StockMarket() {
    }

    public StockMarket(String tickerSymbol, String name, int stockMarketID) {
        this.tickerSymbol = tickerSymbol;
        this.name = name;
        this.stockMarketID = stockMarketID;
    }

    private String tickerSymbol;
    private String name;
    private int stockMarketID;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockMarketID() {
        return stockMarketID;
    }

    public void setStockMarketID(int stockMarketID) {
        this.stockMarketID = stockMarketID;
    }
}
