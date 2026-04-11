# How to execute tests

## Prerequisites

Ensure the following are installed on your system:

- Java (JDK 8 or above)
- IDE (IntelliJ IDEA or Eclipse)
- Browser (Chrome / Edge )

---

## ⚙️ Project Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/GLokesh123/veevaProject
   ```

2. Navigate to the project directory:
   ```bash
   cd veevaProject
   ```

3. Install dependencies:
   ```bash
   mvn clean install
   ```

---

## Test Execution (Using TestNG XML)

1. Open the project in your IDE.
2. Locate the `chromeBrowserTestng.xml` file for chrome and `egdeBrowserTestng.xml`.
3. Right-click on `chromeBrowserTestng.xml` and select **Run** to run on chrome  or Right-click on `edgeBrowserTestng.xml` and select **Run** to run on edge.

---

##  Test Reports

After execution, reports can be found in:

- `test-output/` — TestNG default reports
- Extent Reports 