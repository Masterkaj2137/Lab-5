import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while(true) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Dodaj studenta (imię + wiek)");
        System.out.println("2. Dodaj studenta z dodatkowymi danymi (imię + wiek + kraj)");
        System.out.println("3. Wypisz wszystkich studentów");
        System.out.println("4. Wyjście");
        System.out.print("Wybierz opcję: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // usunięcie \n

        if(option == 1) {
          System.out.print("Podaj imię: ");
          String name = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          int age = scanner.nextInt();
          scanner.nextLine();

          s.addStudent(new Student(name, age));
          System.out.println("Dodano studenta.");
        }
        else if(option == 2) {
          System.out.print("Podaj imię: ");
          String name = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          int age = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Podaj kraj: ");
          String country = scanner.nextLine();

          s.addStudent(new Student(name, age, country));
          System.out.println("Dodano studenta z dodatkowymi danymi.");
        }
        else if(option == 3) {
          var students = s.getStudents();
          System.out.println("\n--- Lista studentów ---");
          for(Student current : students) {
            System.out.println(current.ToString());
          }
        }
        else if(option == 4) {
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
