import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while(true) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Dodaj studenta (imię + wiek + data urodzenia)");
        System.out.println("2. Dodaj studenta z dodatkowymi danymi (imię + wiek + dara urodzenia + kraj)");
        System.out.println("3. Wypisz wszystkich studentów");
        System.out.println("4. Wyszukaj studenta po imieniu");
        System.out.println("5. Wyjście");
        System.out.print("Wybierz opcję: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // usunięcie \n

        if(option == 1) {
          System.out.print("Podaj imię: ");
          String name = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          int age = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Podaj datę urodzenia (dd.mm.rrrr): ");
          String dateOfBirth = scanner.nextLine();

          s.addStudent(new Student(name, age, dateOfBirth));
          System.out.println("Dodano studenta.");
        }
        else if(option == 2) {
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
        }
        else if(option == 3) {
          var students = s.getStudents();
          System.out.println("\n--- Lista studentów ---");
          for(Student current : students) {
            System.out.println(current.ToString());
          }
        }

        else if(option == 4){
          System.out.print("Podaj imię szukanego studenta: ");
          String searchName = scanner.nextLine();

          Student foundStudent = s.findStudentByName(searchName);

          if(foundStudent != null){
            System.out.println("Znaleziono sudenta: " + foundStudent.ToString());
          }
            else{
              System.out.println("Nie znaleziono studenta o danym imieniu.");
            }
          }
      
        else if(option == 5) {
          System.out.println("Koniec.");
          break;
        }
        else {
          System.out.println("Nieprawidłowa opcja!");
        }
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd: " + e.getMessage());
    }
  }
}
