package com.pluralsight;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Book[] library  = getPopulatedLibrary();

    public static void main(String[] args) {

        showScreenHome();
    }

    private static void showScreenHome(){
        String homeScreenPrompt = "Welcome to the  library\n" +
                "Please select an option from following:\n" +
                "   1 - Show available Books\n" +
                "   2 - Show Checked out Books\n" +
                "   0 - Exit App\n" +
                "(1, 2, 0): ";

        int option;

        do {
            System.out.print(homeScreenPrompt);
            option = scanner.nextInt();
            scanner.nextLine();
            if(option == 1) {
                showScreenAvailableBooks();
            } else if (option == 2) {
                showScreenCheckOutBook();
            } else if (option == 0) {
                System.out.println("Exiting the library, have a nice day!");
            } else {
                System.out.println("Not a valid option, please try again.");
            }
        } while (option != 0);
    }
    private static void showScreenAvailableBooks(){

        System.out.println("Available Books:");

        for (Book book : library){
            if(!book.isCheckedOut()){
                System.out.println("ID: " + book.getId() + ", IBSN: " + book.getIsbn() + ", Title: " +  book.getTitle());
            }
        }
            String userPrompt = "Select a option: \n" +
                    "  Y - If you want to select a book to check out\n" +
                    "  N - To go back to the home screen\n";

            String userInput;
            String name;

            do{
                System.out.print(userPrompt);
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("Y")){
                    System.out.print("Please enter the book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("What is your name: ");
                    name = scanner.nextLine();

                    Book theSelectedBook = getBookById(library, bookId);

                    assert theSelectedBook != null;

                    theSelectedBook.checkOut(name);

                    System.out.printf("%s you have checkout out successfully.\n", name);
                } else if (userInput.equalsIgnoreCase("N")){

                } else {
                    System.out.print("Please enter a valid input (Y/N)\n");
                }
            } while (!userInput.equalsIgnoreCase("N"));

    }
    private static void showScreenCheckOutBook(){

        System.out.println("Check Out Books:");

//      Displays a list of all the books that are currently checked out.
        for (Book book : library) {
            if(book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", IBSN: " + book.getIsbn() + ", Title: " + book.getTitle() +", Name: " + book.getCheckedOutTo());
            }
        }
            String userCheckInPrompt = "Select a option: \n" +
                    "  C - If you want to check in a book\n" +
                    "  X - To go back to the home screen\n";

            int bookCheckInId;
            String userInput;
            do {
                System.out.print(userCheckInPrompt);
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("C")){

//                  Check in the book with the specified id
                    System.out.print("Please enter the ID of the book you are checking in: ");
                    bookCheckInId = scanner.nextInt();
                    scanner.nextLine();

//                  Getting the check-out books by their ID
                    Book checkInBook = getCheckOutBooksId(library, bookCheckInId);
                    assert checkInBook != null;
                    checkInBook.checkIn();

                    System.out.printf("Thank you, book id number %d have successfully been checked in.\n", bookCheckInId);
                } else if (userInput.equalsIgnoreCase("X")) {

                }
            } while (!userInput.equalsIgnoreCase("X"));
    }

    private static Book getBookById(Book[] books, int id){
        for(Book book : books){
            if( book.getId() == id){
                return book;
            }
        }
        return null;
    }

    private static Book getCheckOutBooksId(Book[] books, int id){
        for (Book checkOut : books){
            if (checkOut.getId() == id){
                return checkOut;
            }
        }
        return null;
    }

    private static Book[] getPopulatedLibrary(){

        Book[] library = new Book[20];

        library[0] = new Book(1, "ISBN 978-1-78862-355-1", "Nginx HTTP Server");
        library[1] = new Book(2, "ISBN 978-1-4919-1889-0", "Fluent Python");
        library[2] = new Book(3, "ISBN 978-1-59327-599-0", "Automate the Boring Stuff with Python");
        library[3] = new Book(4, "ISBN 978-0-596-52068-7", "Learning Python");
        library[4] = new Book(5, "ISBN 978-1-118-95115-7", "Beginning Programming with Java For Dummies");
        library[5] = new Book(6, "ISBN 978-0-13-468599-1", "Effective Java");
        library[6] = new Book(7, "ISBN 978-1-4919-1881-4", "Python for Data Analysis");
        library[7] = new Book(8, "ISBN 978-1-59327-603-4", "Black Hat Python");
        library[8] = new Book(9, "ISBN 978-1-4919-5459-1", "Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow");
        library[9] = new Book(10, "ISBN 978-0-13-235088-4", "Clean Code");

        library[10] = new Book(11, "ISBN 978-0-321-63537-2", "Design Patterns: Elements of Reusable Object-Oriented Software");
        library[11] = new Book(12, "ISBN 978-1-4919-1882-1", "Think Python");
        library[12] = new Book(13, "ISBN 978-0-321-93418-5", "Refactoring: Improving the Design of Existing Code");
        library[13] = new Book(14, "ISBN 978-1-59327-282-1", "The Linux Command Line");
        library[14] = new Book(15, "ISBN 978-1-59327-424-5", "Hacking: The Art of Exploitation");
        library[15] = new Book(16, "ISBN 978-0-13-417730-4", "The Pragmatic Programmer");
        library[16] = new Book(17, "ISBN 978-1-4919-0201-1", "You Don't Know JS");
        library[17] = new Book(18, "ISBN 978-0-201-61622-4", "The C Programming Language");
        library[18] = new Book(19, "ISBN 978-1-118-88806-4", "Head First Java");
        library[19] = new Book(20, "ISBN 978-0-13-475759-0", "Core Java Volume I: Fundamentals");

        return library;
    }

//    private static void showScreenCheckOutBook(){
//
//        System.out.print("Check Out Books:");
//
//        for (Book book : library) {
//            if(book.isCheckedOut()) {
//                System.out.println("ID: " + book.getId() + ", IBSN: " + book.getIsbn() + ", Title: " + book.getTitle());
//            }
//        }
//        String userCheckInPrompt = "Select a option: \n" +
//                "  C - If you want to check in a book\n" +
//                "  X - To go back to the home screen\n";
//
//        String bookName;
//        do {
//            if (userCheckInPrompt.equalsIgnoreCase("C")){
//                System.out.print("Which Book are checking in? ");
//                bookName = scanner.nextLine();
//
//                System.out.println("You have successfully checked in " + bookName + ".");
//            } else if (userCheckInPrompt.equalsIgnoreCase("X")) {
//
//            }
//        } while (!userCheckInPrompt.equalsIgnoreCase("X"));
//    }


}