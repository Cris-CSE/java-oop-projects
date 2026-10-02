# 01 · Product Pricing

A console program that asks the user for a product category and quantity, calculates the order total and shows the remaining balance for a **3-month credit payment plan**.

## Concepts practiced
- Classes and objects (`new Product()`)
- Instance methods with parameters and return values
- Conditionals (`if / else if / else`)
- `for` loops
- Console input with `Scanner` and formatted output with `printf`

## Prices

| Category | Unit price |
|----------|-----------|
| 1 | 4.50 |
| 2 | 3.50 |
| Any other | 2.50 |

## How to run

```bash
cd src
javac Product.java
java Product
```

## Example

```
Which product would you like to order? 1, 2 or 3?
1
How many products would you like to order?
4
The total price of your order is: 18.00
Balance payable of Month 0 ---> 18.00
Balance payable of Month 1 ---> 12.00
Balance payable of Month 2 ---> 6.00
Balance payable of Month 3 ---> 0.00
```

## Possible improvements
- Validate input (non-numeric values or invalid categories)
- Use `BigDecimal` for exact money calculations
