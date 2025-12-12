public class Student {

  private String Name;
  private int Age;
  private String DateOfBirth;
  private String Country;

  public Student(String name, int age, String dateOfBirth) {
    Name = name;
    Age = age;
    DateOfBirth = dateOfBirth;
    Country = "Unknown";
  }

  public Student(String name, int age, String dateOfBirth, String country) {
    Name = name;
    Age = age;
    DateOfBirth = dateOfBirth;
    Country = country;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetCountry() {return Country;}

  public String ToString() {
    return Name + " " + Age + " " + DateOfBirth + " " + Country;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length < 3) 
      return new Student("ParseError", -1, "Unknown");

    if(data.length == 3)
      return new Student(data[0], Integer.parseInt(data[1]), data[2], "Unknown");

    String country = "";
    for(int i = 3; i < data.length; i++) {
      country += data[i];
      if(i < data.length - 1) country += " ";
    }

    return new Student(data[0], Integer.parseInt(data[1]), data[2], country);
  }
}
