# Date Parsing & Visualization System

## 📌 Overview
This is a Java-based desktop application designed to parse, validate, and organize large sets of raw date data. The application utilizes a **Graphical User Interface (GUI)** built with **Java Swing** to allow users to upload text files containing dates in varying formats.

The system processes these dates, calculates the specific day of the week using **Zeller's Congruence**, and visualizes the data in two side-by-side views: an Input Order (Unsorted) view and a Chronologically Sorted view.

## 🚀 Key Features
* **Data Validation:** Implements a custom exception handling wrapper (`IllegalDate212Exception`) to filter out invalid formats, non-digit characters, and impossible dates (e.g., Month 13 or Day 32).
* **Algorithmic Calculation:** utilized **Zeller's Congruence algorithm** to programmatically determine the day of the week (Monday, Tuesday, etc.) for any given Gregorian date.
* **Custom Data Structures:** Built a **Linked List** architecture from scratch (`Date212List`, `Date212Node`) to handle dynamic data storage, demonstrating manual memory management without relying solely on Java's built-in collections.
* **Interactive GUI:** Features a `JFrame` window with a Menu Bar and `JFileChooser` for intuitive file selection.
* **Sorting Efficiency:** Utilizes `TreeMap` (Red-Black Tree) logic to automatically sort `Date212` objects based on their natural ordering defined by the `Comparable` interface.

## 🛠️ Tech Stack
* **Language:** Java (JDK 17+)
* **GUI Framework:** Java Swing (AWT)
* **Concepts:** OOP, Polymorphism, Linked Lists, Exception Handling, File I/O.

## 📂 Class Structure
* **`Project4.java`:** The main entry point. Handles file processing, tokenizing strings, and populating data structures.
* **`Date212GUI.java`:** Manages the visual presentation, event listeners, and file selection dialogs.
* **`Date212.java`:** The core object model representing a date. Includes parsing logic and the `compareTo` implementation for sorting.
* **`Date212List.java` (Abstract):** The base class for the custom linked list.
* **`UnsortedDate212List.java`:** A concrete implementation of the linked list that preserves insertion order.
* **`IllegalDate212Exception.java`:** Custom exception class for robust error reporting.

## 🔧 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/TaseenAriq06/Java-Date-Parsing-System.git](https://github.com/TaseenAriq06/Java-Date-Parsing-System.git)
    cd Java-Date-Parsing-System
    ```

2.  **Compile the source code:**
    ```bash
    javac *.java
    ```

3.  **Run the application:**
    ```bash
    java Project4
    ```

4.  **Usage:**
    * Click `File` -> `Open`.
    * Select a text file containing dates in `yyyymmdd` format (separated by commas or newlines).
    * The application will display the valid dates with their calculated days of the week.

## 📝 Input File Format
The application expects a `.txt` file with 8-digit strings.
**Example `input.txt`:**
```text
20230101, 20221225
20240229, 19991231
20231301
