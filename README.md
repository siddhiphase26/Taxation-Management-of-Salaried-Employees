# Taxation-Management-of-Salaried-Employees
# 💼 Taxation Management of Salaried Employees (Java + Oracle JDBC)

This project is a **Java-based Taxation Management System** for managing employee information and calculating taxes for salaried employees.
It demonstrates **Oracle Database connectivity using JDBC**, following a clean layered architecture with **POJO**, **Service**, **Implementation**, and **Controller** packages.

---

## 🧩 Project Overview

### 🎯 Objective

To manage employee records and automatically calculate taxes based on income and expenses using JDBC connection to Oracle Database.

---

## 📂 Project Structure

```
Taxation_Management/
├── src/
│   ├── Pojo/
│   │   ├── emp_info.java
│   │   └── tax_info.java
│   ├── Services/
│   │   ├── emp_info_sevices.java
│   │   ├── tax_info_services.java
│   │   ├── empinfo_service_impl.java
│   │   ├── taxinfo_service_impl.java
│   │   └── DB_Connection.java
│   ├── Contoller/
│   │   ├── addemp.java
│   │   ├── get_emp.java
│   │   ├── getall.java
│   │   ├── calculate_tax.java
│   │   └── get_tax_emp.java
└── README.md
```

---

## 🧠 Key Features

✅ Add, view, and list employee details
✅ Calculate tax automatically based on salary
✅ Store and retrieve tax details
✅ Oracle JDBC connection handling
✅ Modular structure with clean separation of layers

---

## ⚙️ Technologies Used

| Component            | Technology                        |
| -------------------- | --------------------------------- |
| Programming Language | Java                              |
| Database             | Oracle 10g/ 11g / 12c / XE             |
| JDBC Driver          | ojdbc17.jar                        |
| IDE                  | IntelliJ IDEA / Eclipse / VS Code |

---

## 🛢️ Database Setup

### Create Tables

```sql
CREATE TABLE emp_info (
  emp_id NUMBER PRIMARY KEY,
  name VARCHAR2(50),
  mobile VARCHAR2(15),
  salary NUMBER,
  addr VARCHAR2(100)
);

CREATE TABLE tax_info (
  emp_id NUMBER PRIMARY KEY,
  name VARCHAR2(50),
  salary NUMBER,
  year NUMBER,
  on_profit NUMBER,
  t_expenses NUMBER,
  tax_amt NUMBER
);
```

---

## 🔗 JDBC Connection

`DB_Connection.java`

```java
public class DB_Connection {
    public static Connection get_DBconnect() throws Exception {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "system";
            String pass = "12345";
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
```

---

## 🧩 POJO Classes

### `emp_info.java`

Holds employee details like:

* emp_id
* name
* mobile
* salary
* addr

### `tax_info.java`

Stores tax-related information:

* emp_id
* name
* salary
* year
* on_profit
* t_expenses
* tax_amt

---

## 🧠 Services Interfaces

### `emp_info_sevices.java`

```java
public interface emp_info_sevices {
    boolean add_emp(emp_info e);
    void get_emp(Integer emp_id);
    List<emp_info> getall_emp();
}
```

### `tax_info_services.java`

```java
public interface tax_info_services {
    void get_emp(Integer emp_id);
    boolean calculate_tax(tax_info e);
}
```

---

## 🔧 Implementation Layer

### `empinfo_service_impl.java`

Handles:

* Adding new employee
* Fetching employee by ID
* Listing all employees

### `taxinfo_service_impl.java`

Handles:

* Calculating and storing tax information
* Retrieving tax details for employees

Tax Calculation Rules:

| Condition           | Tax % | Formula                              |
| ------------------- | ----- | ------------------------------------ |
| Salary < ₹12,00,000 | 0%    | on_profit = salary - expenses        |
| Salary ≥ ₹12,00,000 | 15%   | tax_amt = (salary - expenses) * 0.15 |

---

## 🧰 Controller Layer

### `addemp.java`

Adds a new employee.

```java
emp_info emp = new emp_info(7, "Isha", "9599501089", 9500000L, "Khandala");
empinfo_service_impl ei = new empinfo_service_impl();
ei.add_emp(emp);
```

### `get_emp.java`

Fetches employee details by ID.

```java
empinfo_service_impl e = new empinfo_service_impl();
e.get_emp(1);
```

### `getall.java`

Retrieves all employees.

```java
List<emp_info> list = new empinfo_service_impl().getall_emp();
System.out.println(list);
```

---

## 🧮 Tax Controllers

### `calculate_tax.java`

Calculates and stores tax for a given employee.

```java
package Contoller;

import Pojo.tax_info;
import Services.taxinfo_service_impl;

public class calculate_tax {
    public static void main(String[] args) {
        tax_info tax = new tax_info(
                7, "Isha", 9500000L, 2024, 0L, 50000L, 0L
        );

        taxinfo_service_impl t_service = new taxinfo_service_impl();
        boolean result = t_service.calculate_tax(tax);

        if (result) {
            System.out.println("✅ Tax calculation completed successfully!");
        } else {
            System.out.println("❌ Tax calculation failed!");
        }
    }
}
```

### `get_tax_emp.java`

Fetches tax details for a specific employee.

```java
package Contoller;

import Services.taxinfo_service_impl;

public class get_tax_emp {
    public static void main(String[] args) {
        taxinfo_service_impl t_service = new taxinfo_service_impl();
        t_service.get_emp(7);
    }
}
```

---

## 🧾 Sample Output

```
✅ Connected to Oracle Database Successfully!
Employee Details:
7 | Isha | 9599501089 | 9500000 | Khandala

Tax Applied 15%
'1' rows updated
✅ Tax calculation completed successfully!
```

---

## 🧑‍💻 How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/Taxation-Management-Employees.git
   ```
2. Open the project in your preferred IDE.
3. Add `ojdbc8.jar` to your classpath.
4. Update Oracle **username**, **password**, and **port** in `DB_Connection.java`.
5. Run the controller files in order:

   * `addemp.java`
   * `get_emp.java`
   * `getall.java`
   * `calculate_tax.java`
   * `get_tax_emp.java`




