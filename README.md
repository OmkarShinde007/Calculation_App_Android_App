# Calculation_App_Android_App

Develop an Expression Calculation App with the following specifications:

**App Features:**
- The application consists of two primary screens: the `HomeScreen` and the `HistoryScreen`.
- On the `HomeScreen`, users will find an input field, a calculation button, and a result display.
- The input field accepts multiple expressions, with each expression separated by a new line.
- Expression results are fetched from an API using the `retrofit` library.
- The `HistoryScreen` displays a complete history of calculations, including the expression, result, and timestamp.
- Calculations are stored locally in a SQLite/Room database.

**Implemented Features:**
- A `MainActivity` launches the `HomeFragment` via navigation through the `nav_graph`.
- The `HomeFragment` features a custom material toolbar, a Material Input for entering expressions, a Material Button to trigger calculations, a Material TextView to display results, and a floating action button for navigating to the `HistoryFragment`.
- The Material Input accepts multiple expressions with new lines as separators.
- The MathJS API is used to calculate expression results, and Retrofit handles the API requests and responses.
- The app adheres to the MVVM architecture.
- Room database components include `HistoryDao`, `HistoryDatabase`, and `HistoryRepository`.
- A RecyclerView is used to display the calculation history, managed by `HistoryListAdapter` and `HistoryListViewHolder`.
- In the `HistoryFragment`, each history entry shows the date and time, the expression, and the result within a card view.
- The `HistoryDataViewModel` manages requests and retrieves data from the Room database, using Kotlin coroutines for background tasks.

**Additional Resources:**

**Video:**
- [Demo App Functionalities](https://drive.google.com/file/d/1WcKySmoqnAreYJIqYeSFJpDo3srJ_xNO/view?usp=drive_link)
- [Demo Multiple Expression](https://drive.google.com/file/d/1velsyRnH0IwuOZ95t8pBxPZGXLu0Gvhv/view?usp=drive_link)

**Screenshots:**
- [Home Screen Default](https://drive.google.com/file/d/1KR-O1lf5UiptgXijS_uJFfar2uHQCS_C/view?usp=drive_link)
- [Home Screen Input](https://drive.google.com/file/d/1R6w4n-u3hmatrw6ZS5S4SCnhacpDB1Ed/view?usp=drive_link)
- [History Screen](https://drive.google.com/file/d/16gomrWHfQFgWPEXBVd0vLgVlesaAfjow/view?usp=drive_link)

**App Bundle :** https://drive.google.com/drive/folders/1xHwbtffzgvon3tNPSRoh4i7TOBZ-mDTC?usp=drive_link

The app has been manually tested to ensure functionality.
