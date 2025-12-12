import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Dodaj studenta (imię + wiek + data urodzenia)");
        System.out.println("2. Dodaj studenta z dodatkowymi danymi (imię + wiek + dara urodzenia + kraj)");
        System.out.println("3. Wypisz wszystkich studentów");
        System.out.println("4. Wyszukaj studenta po imieniu");
        System.out.println("5. Usuń studenta po imieniu");
        System.out.println("6. Zaktualizuj wiek studenta");
        System.out.println("7. Zrób backup (eksport)");
        System.out.println("8. Przywróć backup (import)");
        System.out.println("9. Wyjście");
        System.out.print("Wybierz opcję: ");
        // .

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
          System.out.print("Podaj imię: ");
          String name = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          int age = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Podaj datę urodzenia (dd.mm.rrrr): ");
          String dateOfBirth = scanner.nextLine();

          s.addStudent(new Student(name, age, dateOfBirth));
          System.out.println("Dodano studenta.");
        } else if (option == 2) {
          System.out.print("Podaj imię: ");
          String name = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          int age = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Podaj datę urodzenia (dd.mm.rrrr): ");
          String dateOfBirth = scanner.nextLine();

          System.out.print("Podaj kraj: ");
          String country = scanner.nextLine();

          s.addStudent(new Student(name, age, dateOfBirth, country));
          System.out.println("Dodano studenta z dodatkowymi danymi.");
        } else if (option == 3) {
          var students = s.getStudents();
          System.out.println("\n--- Lista studentów ---");
          for (Student current : students) {
            System.out.println(current.ToString());
          }
        }

        else if (option == 4) {
          System.out.print("Podaj imię szukanego studenta: ");
          String searchName = scanner.nextLine();

          Student foundStudent = s.findStudentByName(searchName);

          if (foundStudent != null) {
            System.out.println("Znaleziono sudenta: " + foundStudent.ToString());
          } else {
            System.out.println("Nie znaleziono studenta o danym imieniu.");
          }
        }

        else if (option == 5) {
          System.out.print("Podaj imię studenta do usunięcia: ");
          String deleteName = scanner.nextLine();
          boolean deleted = s.deleteStudent(deleteName);

          if (deleted) {
            System.out.println("Pomyślnie usunięto studenta z listy.");
          } else {
            System.out.println("Nie znaleziono studenta o danym imieniu.");
          }
        }

        else if (option == 6) {
          System.out.print("Podaj imię studenta do aktualizacji: ");
          String updateName = scanner.nextLine();

          Student existing = s.findStudentByName(updateName);
          if (existing != null) {
            System.out.print("Podaj nowy wiek: ");
            int newAge = scanner.nextInt();
            scanner.nextLine();

            boolean updated = s.updateStudent(updateName, newAge);
            if (updated) {
              System.out.println("Zaktualizowano wiek student.");
            } else {
              System.out.println("Błąd podczas aktualizacji wieku.");
            }
          } else {
            System.out.println("Nie znaleziono studenta o danym imieniu.");
          }
        }

        else if (option == 7) {
          s.backupDb();
          System.out.println("Wykonano kipię zapasową (db_backup.txt).");
        }

        else if (option == 8) {
          s.restoreDb();
          System.out.println("Przywrócono dane z kopii zapasowej.");
        }

        else if (option == 9) {
          System.out.println("Koniec.");
          break;
        } else {
          System.out.println("Nieprawidłowa opcja!");
        }
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
