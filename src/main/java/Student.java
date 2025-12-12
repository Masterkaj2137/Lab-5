public class Student {

  private String Name;
  private int Age;
  private String Country;

  public Student(String name, int age) {
    Name = name;
    Age = age;
    Country = "Unknown";
  }

  public Student(String name, int age, String country) {
    Name = name;
    Age = age;
    Country = country;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetCountry() {return Country;}

  public String ToString() {
    return Name + ", " + Age + ", " + Country;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length < 2) 
      return new Student("ParseError", -1, "Unknown");

    if(data.length == 2)
      return new Student(data[0], Integer.parseInt(data[1]), "Unknown");

    String country = "";
    for(int i = 2; i < data.length; i++) {
      country += data[i];
      if(i < data.length - 1) country += " ";
    }

    return new Student(data[0], Integer.parseInt(data[1]), country);
  }
}
