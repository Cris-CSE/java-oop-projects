class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    //This is a constructor, which creates a stock with a specific symbol and name.
    Stock(String newSymbol, String newName) {
        symbol = newSymbol;
        name = newName;
    }

    //Here sets the previous closing price.
    void setPreviousPrice(double newPreviousClosingPrice) {
        previousClosingPrice = newPreviousClosingPrice;
    }

    //Here sets the current price.
    void setNewPrice(double newCurrentPrice) {
        currentPrice = newCurrentPrice;
    }

    //Returns the percentage change from previousClosingPrice to currentPrice; that is, this method returns a double value because the percentage can have decimals.
    double getChangePercent() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }

}

public class TestStock {
    public static void main(String[] args) {
        //Creates a Stock object with the required symbol and name
        Stock stock = new Stock("NFLX", "Netflix Corporation");

        //Sets the previous closing price.
        stock.setPreviousPrice(337.5);

        //Sets the new current price.
        stock.setNewPrice(345.23);

        //Displays the price-change percentage.
        System.out.printf("%s (%s)%n", stock.name, stock.symbol);
        System.out.printf("The price-change percentage is: %.2f%%%n", stock.getChangePercent());
    }
}
