
public class Person {

    private String name;
    private String surname;
    private String email;


    //parameterized constructor;
    public Person(String name, String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    //getters and setters;
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(){
        this.surname=surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email=email;
    }

    //print person information;
    public void personInfo(){
        System.out.println("Name:"+" "+name);
        System.out.println("Surname:"+" "+surname);
        System.out.println("Email:"+" "+email);
    }
}





