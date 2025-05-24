
import java.util.InputMismatchException;
import java.util.Scanner;



public class CinemaManagement {

    //declaration for rows,columns and prices.
    // using final keyword,because the value can't be changed once it has been initialized;
    private static final int ROWS = 3;
    private static final int COLUMNS = 16;
    private static final int[] PRICES = {12, 10, 8};

    //2-d array declaration;
    private static final int[][] seats = new int[ROWS][COLUMNS];

    private static final int maximumTickets = 48;//Using final:the value can't be changed.
    //declaration of the ticket array.
    private static final Ticket[] tickets = new Ticket[maximumTickets];
    private static int ticketIndex = 0;


    public static void main(String[] args) {

        //welcome message;
        System.out.println(" 'Welcome to the London Lumiere.' ");

        initializeSeats();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            displayMenu();

            //get user input;
            int selectOption = scanner.nextInt();
            scanner.nextLine();

            String option = (" ");


            switch (selectOption) {
                case 1:
                    option = "Buy a ticket";
                    buy_ticket();
                    break;
                case 2:
                    option = "Cancel a ticket";
                    cancel_tickets();
                    break;
                case 3:
                    option = "See a seating plan";
                    print_seating_area();
                    break;
                case 4:
                    option = "Find first seat available";
                    find_first_available();
                    break;
                case 5:
                    option = "print ticket information and total price";
                    break;
                case 6:
                    option = "Search ticket";
                    break;
                case 7:
                    option = "Sort tickets by price";
                    break;
                case 8:
                    running = false;
                    option = "Exiting the programme.Have a nice day!";
                    break;

                default:
                    option = "Invalid";
                    break;
            }

            System.out.println("Your option is:" + " " + option);


            if (selectOption < 8) {
                System.out.println("Please select an another option or exit.");//you can choose to another option or exit.

            } else {
                System.out.println("Exit.");
            }

        }
    }

    //seat initialization;
    private static void initializeSeats() {
        //using nested for loop;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                seats[row][col] = 0;

            }
        }

    }


    private static void displayMenu() {


        System.out.println("----------------------------------");

        System.out.println("Please select an option:");
        System.out.println("(1). Buy a ticket");
        System.out.println("(2). Cancel a ticket");
        System.out.println("(3). See seating plan");
        System.out.println("(4). Find first seat available");
        System.out.println("(5). Print tickets information and total price");
        System.out.println("(6). Search ticket");
        System.out.println("(7). Sort tickets by price");
        System.out.println("(8). Exit");

        System.out.println("----------------------------------");

        System.out.println("Select option:");


    }


    //Buy ticket method;
    private static void buy_ticket() {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int seat = -1;
        while (true) {
            try {
                do {
                    System.out.println("Input a row number (1 to 3).");
                    row = scanner.nextInt();

                } while (row < 1 || row > ROWS);
                do {
                    System.out.println("Input a seat number (1 to 16)");
                    seat = scanner.nextInt();

                } while (seat < 1 || seat > COLUMNS);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next();
            }
        }
        //Input validation;

//        if   (row < 1 || row > ROWS || seat < 1 || seat > COLUMNS)  {
//            System.out.println("Invalid row number or seat number or both.Please enter valid numbers.");
//
//                }

           if (seats[row - 1][seat - 1] == 0) { //check availability;0 to indicate the seat is available.
                seats[row - 1][seat - 1] = 1; //(row-1)is the length of (n)th row. (seat-1)is the length of (n)th seat.
                System.out.println("If you want to book the seat,please fill this information.");

            } else {
                System.out.println("The seat is not available.");
            }
            ticketInformation(row, seat);

        }



    private static void ticketInformation(int row, int seat) {

        int price;

        if (row < 1 || row > ROWS || seat < 1 || seat > COLUMNS) {
            System.out.println("Invalid row number or seat number or both.Please enter valid numbers.");
        }

        //getting user information;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your surname");
        String surname = scanner.nextLine();

        //email validation;

        String email = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter your email:");
            email = scanner.nextLine();
            if (email.contains("@")) {
                valid = true;
            } else {
                System.out.println("Your email is invalid");
            }
        }
        System.out.println("The seat has been booked.");


        //calculate the price;
        if (row == 1) {
            price = 12;
        } else if (row == 2) {
            price = 10;
        } else {
            price = 8;
        }

        //create a new ticket and add it to the ticket array.
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(row, seat, price, person);
        if (ticketIndex < maximumTickets) {
            tickets[ticketIndex] = ticket;//declare of the ticket array.
            ticketIndex++;
        } else {
            System.out.println("Ticket tray is full.");
        }
        ticket.printTicketInfo();
        ticket.save();


    }


    //Cancel ticket method;
    private static void cancel_tickets() {

        Scanner scanner = new Scanner(System.in);

        int row ;
        int seat ;
        while (true) {
            try {
                do {
                    System.out.println("Enter your current row number (1 to 3):");
                    row = scanner.nextInt();

                } while (row < 1 || row > ROWS);
                do {
                    System.out.println("Enter your current seat number (1 to 16):");
                    seat = scanner.nextInt();

                } while (seat < 1 || seat > COLUMNS);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next();
            }
        }


//        System.out.println("Enter your current row number (1 to 3):");
//         row = scanner.nextInt();
//        System.out.println("Enter your current seat number (1 to 16):");
//         seat = scanner.nextInt();

        //Input validation
//        if (row < 1 || row > ROWS || seat < 1 || seat > COLUMNS) {
//            System.out.println("Invalid row number or seat number or both.please enter valid numbers.");
//        } else
            if (seats[row - 1][seat - 1] == 1) { //check for cancellation; 1 to indicate the seat is already booked.
            seats[row - 1][seat - 1] = 0;
            System.out.println("The seat has been cancelled");

        } else {
                System.out.println("Seat is not taken, nothing to cancel");
            }


        //ticket founding and cancelling;

        for (int i = 0; i < ticketIndex; i++) { // int i: use for finding the ticket.
            if (tickets[i].getRow() == row  && tickets[i].getSeat() == seat ) {
                seats[row][seat] = 0;//the seat is now available.

                //The cancelled ticket shift to the remaining ticket to fill the gap.
                for (int r = i; r < ticketIndex - 1; r++) {//int r:use for shift to remaining tickets.
                    tickets[r] = tickets[r + 1];//the ticket is shifted.

                }
                //gap filling;
                tickets[ticketIndex - 1] = null;//clear the last slot.
                ticketIndex--;//decremented the ticket index of the array.
                System.out.println("Your ticket cancellation is successful");

            }
            else {
                System.out.println("Your ticket cancellation is unsuccessful.");
                break;
            }

        }


        }




    private static void print_seating_area() {
        System.out.println("********************");
        System.out.println("*      SCREEN      *");
        System.out.println("********************");

//using nested for loop
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {


                if (col == 8) {
                    System.out.print(" ");//gap for the between 8 and 9 seats of  each row;
                }
                if (seats[row][col] == 0) {
                    System.out.print("0");//print 0 for available seats.
                } else {
                    System.out.print("X");//print x for booked seats
                }

            }
            System.out.println();//added new line of  each row

        }
    }
    private static void find_first_available(){
        boolean seatFound=false; //first available seat found is not yet.
        for (int row=0; row<ROWS && !seatFound; row++){ //the both conditions are true because !seat_found is equal to seat_found is=false,for still have not found first available seat.
            for (int col=0; col<COLUMNS && !seatFound; col++){
                if(seats [row][col]==0){
                    System.out.println("Find first available row"+" "+(row+1)+" "+"and seat"+" "+(col+1));//(row+1)and(col+1) because java array indexes start in 0.
                    seatFound=true;//this step is to use stop the both loops.because avoid the unnecessary checks.
                }

            }
        }
        if(!seatFound){//find to no available seat.
            System.out.println("No available seat.");
        }
    }
}












