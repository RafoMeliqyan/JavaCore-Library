
import model.Lesson;
import storage.DynamicArrayForBook;

import java.util.Scanner;

public class BookTest implements Commands{
    private static Scanner scanner = new Scanner(System.in);
    private static DynamicArrayForBook dynamicArrayForBook = new DynamicArrayForBook();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            showCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_BY_TITLE:
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    private static void showCommands() {
        System.out.println("Please input" + EXIT + "for EXIT");
        System.out.println("Please input " + ADD_BOOK + "for ADD BOOK");
        System.out.println("Please input " + SEARCH_BY_TITLE + "for SEARCH BOOK BY TITLE");
    }

    private static void addBook() {
        System.out.println("Please input Book data");
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("authorName:");
        String authorName = scanner.nextLine();
        System.out.println("price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("count:");
        int count = Integer.parseInt(scanner.nextLine());
        Lesson book = new Lesson(title, authorName, price, count);
        dynamicArrayForBook.add(book);
        System.out.println("Book  was added");
    }

    private static void searchBookByTitle() {
        System.out.println("Please input title for search");
        String searchTitle = scanner.nextLine();
        Lesson searchBook = dynamicArrayForBook.getBookByTitle(searchTitle);
        if (searchBook == null) {
            System.out.println("Book with" + searchTitle + " title does not exists");
        } else {
            System.out.println(searchBook);
        }
    }
}
