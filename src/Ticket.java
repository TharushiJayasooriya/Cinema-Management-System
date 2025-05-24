import java.io.File;
import java.io.FileWriter;
import  java.io.IOException;



public class Ticket {
    private int row;
    private int seat;
    private int price;
    private Person person;

    //parameterized constructor;
    public Ticket (int row, int seat, int price, Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;

    }
    //getters and setters.
    public int getRow(){
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat(){
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //print ticket information;
    public void printTicketInfo(){
        System.out.println("row number:"+" "+row);
        System.out.println("seat number:"+" "+seat);
        System.out.println("Price is:"+" "+"£"+price);
        person.personInfo();
    }
    //using default access modifier:because ticket information is saved by restricting access.
    //using a file handling:store to the ticket information data.
    void save(){
        try {
            File file=new File(row + seat +".text");
            file.createNewFile();//try to create a file.
            FileWriter Writer=new FileWriter(row +seat +".text");
            Writer.write("Row:"+row);
            Writer.write("\nSeat:"+seat);
            Writer.write("\nPrice £ "+price);
            Writer.write("\nName:"+person.getName());
            Writer.write("\nSurname:"+person.getSurname());
            Writer.write("\nEmail:"+person.getEmail());
            Writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }



}
