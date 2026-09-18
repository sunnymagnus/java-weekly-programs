import java.util.Scanner;

class Book {
    // Attributes
    String title, author, publisher, isbn;
    int year;
    double price;

    // Default Constructor
    Book() {
        title = "";
        author = "";
        publisher = "";
        isbn = "";
        year = 0;
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String t, String a, String p, int y, String i, double pr) {
        title = t;
        author = a;
        publisher = p;
        year = y;
        isbn = i;
        price = pr;
    }

    // Copy Constructor
    Book(Book b) {
        title = b.title;
        author = b.author;
        publisher = b.publisher;
        year = b.year;
        isbn = b.isbn;
        price = b.price;
    }

    // Display Method
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year: " + year);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price);
        System.out.println("----------------------");
    }

    // Match Method
    boolean matches(String keyword) {
        return title.equalsIgnoreCase(keyword) ||
               author.equalsIgnoreCase(keyword);
    }

    // Apply Discount
    void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }
}

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array of Book objects
        Book[] b = new Book[3];

        b[0] = new Book("Java", "James", "Sun", 1995, "111", 500);
        b[1] = new Book("Python", "Guido", "PythonOrg", 2000, "222", 400);
        b[2] = new Book("C", "Dennis", "PHI", 1980, "333", 300);

        // Display all books
        System.out.println("All Books:");
        for (int i = 0; i < 3; i++) {
            b[i].displayDetails();
        }

        // Search
        System.out.print("Enter title/author to search: ");
        String key = sc.next();

        System.out.println("Search Results:");
        for (int i = 0; i < 3; i++) {
            if (b[i].matches(key)) {
                b[i].displayDetails();
            }
        }

        // Apply discount
        System.out.print("Enter discount %: ");
        double d = sc.nextDouble();

        for (int i = 0; i < 3; i++) {
            b[i].applyDiscount(d);
        }

        // Display after discount
        System.out.println("After Discount:");
        for (int i = 0; i < 3; i++) {
            b[i].displayDetails();
        }

        sc.close();
    }
}
