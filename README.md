Zmiany w poszczególnych commitach:

**Commit5_1.1:**

Student.java: Dodano prywatne pole String DateOfBirth. Zaktualizowano konstruktory oraz metody ToString() i Parse() o obsługę nowego pola.

Main.java: Dodano obsługę wczytywania daty urodzenia w Scanner dla opcji dodawania studenta.


**Commit5_1.2:**

Service.java: Zaimplementowano metodę findStudentByName(String name), przeszukującą listę studentów.

Main.java: Dodano opcję w menu ("Wyszukaj studenta"), która pobiera imię od użytkownika i wyświetla znalezionego studenta.

**Commit5_1.3:**

Service.java: Dodano metodę deleteStudent(String name), która tworzy nową listę bez wskazanego studenta i nadpisuje plik db.txt.

Main.java: Dodano opcję w menu obsługującą usuwanie (pobranie imienia i wywołanie metody serwisu).


**Commit5_1.4:**

Student.java: Dodano metodę SetAge(int age) umożliwiającą modyfikację pola wieku.

Service.java: Dodano metodę updateStudent(String name, int newAge), która wyszukuje studenta, modyfikuje obiekt i nadpisuje bazę danych.

Main.java: Dodano opcję w menu do aktualizacji wieku (pobranie danych i wywołanie metody serwisu).


**Commit5_1.5:**

Kasowanie wybranego studenta zostało zrealizowane w Commicie 5_1.3


**Commit5_1.6:**

Service.java: Dodano metody backupDb() (kopiowanie db.txt do db_backup.txt) oraz restoreDb() (nadpisywanie db.txt zawartością backupu).

Main.java: Dodano dwie nowe opcje w menu wywołujące odpowiednio backup i przywracanie bazy.


**Commit5_1.7:**

Service.java: Dodano metodę getStudentsSortedByName(), wykorzystującą Collections.sort oraz anonimowy Comparator do sortowania alfabetycznego bez naruszania pliku źródłowego.

Main.java: Dodano opcję wyświetlającą posortowaną listę w konsoli.
