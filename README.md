# Library‑Management System (Java)

A lightweight console application that demonstrates how to build a small‑scale library back‑end in **plain Java** — no external collections or ORM frameworks.

## Key Features

* **Custom data structures**: `CustomArrayList`, `CustomLinkedList`, `CustomQueue`, `CustomStack`, `CustomHashMap`
* **Domain layer**: POJO classes `Book`, `Member`, `Transaction`
* **Manager layer**: `BookManager`, `MemberManager`, `TransactionManager`
* **CLI workflow**: menu‑driven interface in `Library` enables borrowing, returning, and inventory look‑ups

## Project Layout

```
src/
 ├─ datastructures/        ← custom collections
 ├─ model/                 ← domain entities
 ├─ manager/               ← services / controllers
 └─ Library.java           ← main entry point
```


### Requirements

* JDK 17 or higher
* No third‑party libraries required
