package course;

/**
 * Class to represent a student in a course.
 * @author Benjamin Carle
 */
public class Student
{
  //---//---//---// Fields //---//---//---//
  private String name;
  private double [] grades;

  //---//---//---// Constructors //---//---//---//
  /**
   * Default constructor.
   */
  public Student() {}

  /**
   * Constructor that takes the name and grades
   * as an array of double values.
   * @param name the student's name
   * @param grades the student's grades
   */
  public Student(String name, double [] grades)
  {
    // set the name
    this.name = name;
    this.grades = grades;
  }
  
  
  /**
   * Constructor that takes a delimited string 
   * of the form NAME:GRADE1,GRADE2,GRADE3,...
   * and creates a student object.
   * @param the delimited string
   */
  public Student(String delim)
  {
    String [] split1 = delim.split(":");
    this.name = split1[0].trim();
    String [] split2 = split1[1].split(",");
    this.grades = new double[split2.length];
    for(int i = 0; i < split2.length; i++)
      grades[i] = Double.parseDouble(split2[i]);
  }
  
  //---//---//---// Methods //---//---//---//
  /**
   * Accessor method for name
   * @return the name
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * Modifier method for name.  Only allows
   * setting the name if the name has not 
   * yet been set.
   * @param name the student's name
   * @return true if the name was set, false otherwise
   */
  public boolean setName(String name)
  {
    if(this.name == null) {
      this.name = name;
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Accessor method for a single grade.
   * @param index the index of the grade to return
   * @return the grade at index
   */
  public double getGrade(int index)
  {
    if(grades == null || grades.length == 0 ||
       index < 0 || index >= grades.length)
      return 0.0;
    return grades[index];
  }
  
  /**
   * Method to return the number of grades stored.
   * @return the number of grades
   */
  public int getNumGrades()
  {
    return grades.length;
  }

  /**
   * Modifier method for a single grade
   * @param index the index of the grade to change
   * @param grade the new grade
   * @return true if the grade was set, false otherwise
   */
  public boolean setGrade(int index, double grade)
  {
    if(grades == null || grades.length == 0 ||
       index < 0 || index >= grades.length)
      return false;
    if(grade < 0)
      grade = 0;
    if(grade >= 100)
      grade = 100;
    grades[index] = grade;
    return true;
  }
  
  /**
   * Method to compute the average of the grades.
   * @return the grade average
   */
  private double getAverage()
  {
    if(grades == null || grades.length == 0)
      return 0.0;
    double sum = 0;
    for(int i = 0; i < grades.length; i++)
      sum += grades[i];
    return sum / grades.length;
  }
  
  /**
   * Method to return a string describing
   * the student.
   * @return the string describing the student
   */
  public String toString()
  {
    return "Student with name " + this.name + 
      " and grade average " + this.getAverage();
  }
  
  /**
   * Main method for testing.
   */
  public static void main(String [] args)
  {
    Student s1 = new Student();
    System.out.println(s1); 
    
    double [] grades2 = {90.5, 88.0, 92.3, 79.1};
    Student s2 = new Student("Beta", grades2);
    System.out.println(s2); 
    
    Student s3 = new Student(" John Smith : 84.2, 92.8, 85.5, 90.0 ");
    System.out.println(s3);
  }
}