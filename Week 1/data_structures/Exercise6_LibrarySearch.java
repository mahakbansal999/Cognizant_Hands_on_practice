import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return String.format("Book[id=%s, title=%s, author=%s]", bookId, title, author);
    }
}

public class Exercise6_LibrarySearch {

    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int low = 0, high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B3", "The Pragmatic Programmer", "David Thomas"),
            new Book("B1", "Clean Code", "Robert Martin"),
            new Book("B2", "Introduction to Algorithms", "Cormen et al.")
        };

        System.out.println(linearSearchByTitle(books, "Clean Code"));

        Book[] sorted = books.clone();
        Arrays.sort(sorted, Comparator.comparing(Book::getTitle));
        System.out.println(binarySearchByTitle(sorted, "Clean Code"));
    }
}
