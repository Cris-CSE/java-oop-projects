# 03 · Hospital System

A small hospital registration system that models different kinds of people with a common **abstract superclass**. Each type of person implements its own registration behavior, and all of them are processed together through polymorphism.

## Concepts practiced
- **Inheritance** (`extends`, `super(...)`)
- **Abstract classes and methods** (`abstract class Person`, `abstract void register()`)
- **Polymorphism** (an array of `Person` references calling each subclass's `register()`)
- **Encapsulation** (`private` fields with getters)
- **Constructor overloading and chaining** (`this(...)` in `Guard`)

## Class hierarchy

```
          Person (abstract)
          - name, age
          + register()  «abstract»
         /       |        \
   Doctor     Patient     Guard
 department   illness    shift, phone
```

## How to run

```bash
cd src
javac HospitalTest.java
java HospitalTest
```

## Example output

```
Registration messages:
Welcome Doctor!
Welcome Patient!
Welcome Guard!
Welcome Guard!

Doctor information:
Name: Joseph
Age: 41
Department: Neurologist
...
```
