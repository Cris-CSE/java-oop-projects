# 02 · Stock Exchange

Models a stock from the American stock market with a `Stock` class and calculates the **percentage change** between its previous closing price and its current price.

## Concepts practiced
- Designing a class with fields (symbol, name, previous closing price, current price)
- Constructors
- Setter methods and a calculation method
- Formatted output with `printf`

## Class design

```
┌──────────────────────────────────────┐
│                Stock                 │
├──────────────────────────────────────┤
│ symbol: String                       │
│ name: String                         │
│ previousClosingPrice: double         │
│ currentPrice: double                 │
├──────────────────────────────────────┤
│ Stock(symbol, name)                  │
│ setPreviousPrice(price: double)      │
│ setNewPrice(price: double)           │
│ getChangePercent(): double           │
└──────────────────────────────────────┘
```

## How to run

```bash
cd src
javac TestStock.java
java TestStock
```

## Example output

```
Netflix Corporation (NFLX)
The price-change percentage is: 2.29%
```

## Possible improvements
- Make fields `private` and add getters (encapsulation)
- Guard against division by zero when the previous price is not set
