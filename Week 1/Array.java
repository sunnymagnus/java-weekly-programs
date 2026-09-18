import java.util.Scanner;

class Book {
    String title, author, publisher, isbn;
    int year;
    double price;
    Book() { this("", "", "", 0, "", 0); }
    Book(String title, String author, String publisher, int year, String isbn, double price) {
        this.title = title; this.author = author; this.publisher = publisher;
        this.year = year; this.isbn = isbn; this.price = price;
    }
    Book(Book other) { this(other.title, other.author, other.publisher, other.year, other.isbn, other.price); }
    void displayDetails() { System.out.printf("Title: %s%nAuthor: %s%nPublisher: %s%nYear: %d%nISBN: %s%nPrice: %.2f%n----------------------%n", title, author, publisher, year, isbn, price); }
    boolean matches(String keyword) { return title.equalsIgnoreCase(keyword) || author.equalsIgnoreCase(keyword); }
    void applyDiscount(double percentage) { price -= price * percentage / 100; }
}

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = { new Book("Java", "James", "Sun", 1995, "111", 500), new Book("Python", "Guido", "PythonOrg", 2000, "222", 400), new Book("C", "Dennis", "PHI", 1980, "333", 300) };
        System.out.println("All Books:");
        for (Book book : books) book.displayDetails();
        System.out.print("Enter title/author to search: ");
        String key = sc.nextLine();
        System.out.println("Search Results:");
        for (Book book : books) if (book.matches(key)) book.displayDetails();
        System.out.print("Enter discount %: ");
        double discount = sc.nextDouble();
        for (Book book : books) book.applyDiscount(discount);
        System.out.println("After Discount:");
        for (Book book : books) book.displayDetails();
        sc.close();
    }
}
