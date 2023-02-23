package cz.educanet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class stockMarketResources {

    private StockMarket m = null;
    private trade t = null;

    public void createStock(String ticker, String name) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO stock_market.stock_market(ticker_symbol, descriptive_name) VALUES (?, ?)"
                );

        ) {
            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTrade(int amount, int price) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO stock_market.trade(amount, price) VALUES (' ?, ?')"
                );

        ) {
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, price);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStock(int stockID) {
        System.out.println(stockID);
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM stock_market.stock_market where stock_market_id = ?"
                );

        ) {
            preparedStatement.setInt(1, stockID);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStock(String ticker, String name, int stockID) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE stock_market.stock_market SET ticker_symbol = ?, descriptive_name = ? where stock_market_id = ?"
                );

        ) {
            preparedStatement.setInt(3, stockID);
            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StockMarket SpecificMarket(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT s.descriptive_name, s.ticker_symbol, s.stock_market_id FROM stock_market.stock_market AS s WHERE stock_market_id = ?"
                ))

        {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new StockMarket(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StockMarket> getStock() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT s.descriptive_name, s.ticker_symbol, s.stock_market_id FROM stock_market.stock_market AS s")
        ) {
            ArrayList<StockMarket> stockArray = new ArrayList<>();

            while (resultSet.next()) {
                stockArray.add(new StockMarket(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }

            return stockArray;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public trade getSpecificTrade(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/superhero?user=root&password=");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT trade.amount, trade.price, trade.created_at FROM stock_market.trade AS trade WHERE stock_market_id = ?"
                ))

        {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new trade(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getTimestamp(4).toLocalDateTime(),
                        resultSet.getInt(5)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public StockMarket getSpecificMarket() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if(m == null || m.getStockMarketID() != Integer.parseInt(id)) {
            m = SpecificMarket(Integer.parseInt(id));
        }
        return m;
    }

    public trade getSpecificTrade() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if(t == null || t.getStockMarketID() != Integer.parseInt(id)) {
            t = getSpecificTrade(Integer.parseInt(id));
        }
        return t;
    }
    public void updateMarket(String ticker, String name) throws IOException {
        System.out.println(m.getName());
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        updateStock(ticker, name, Integer.parseInt(id));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }



}
