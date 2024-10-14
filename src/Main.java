import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ComicBook> comicList = new ArrayList<ComicBook>();
        ComicBook comic1 = new ComicBook("Ironman");
        ComicBook comic2 = new ComicBook("Batman");
        comicList.add(comic1);
        comicList.add(comic2);

        List<Magazine> magazineList = new ArrayList<Magazine>();
        Magazine magazine1 = new Magazine("Rolling Stones");
        Magazine magazine2 = new Magazine("Forbes");
        magazineList.add(magazine1);
        magazineList.add(magazine2);

        List<Novel> novelList = new ArrayList<Novel>();
        Novel novel1 = new Novel("Harry Potter");
        Novel novel2 = new Novel("Green Eggs and Ham");

        List<Literature> books = new ArrayList<>();
        BookStore<Literature> library = new BookStore<>("Babel's Library", books);

        library.addItem(novel1);
        library.addItem(novel2);
        library.addItem(comic1);
        library.addItem(comic2);
        library.addItem(magazine1);
        library.addItem(magazine2);

        library.addItem(new Novel("War and Peace"));
        library.addItem(new ComicBook("Spider-Man 1"));
        library.addItem(new ComicBook("Spider-Man 2"));
        library.addItem(new ComicBook("Spider-Man 3"));
        library.addItem(new Magazine("National Geographic"));

        library.printItems();

        System.out.println("\nAlpha Order: ");
        library.printTitlesInAlphaOrder();
        System.out.println("Test:");

                library.printBookTitle("Spider-Man");



        BookStore<Novel> novelBookStore = new BookStore<>("Novel Haven", new ArrayList<>());

        // Add some novels to the bookstore
        novelBookStore.addItem(new Novel("Pride and Prejudice"));
        novelBookStore.addItem(new Novel("The Great Gatsby"));
        novelBookStore.addItem(new Novel("To Kill a Mockingbird"));

        BookStore<Novel>.NovelStatistics statistics = novelBookStore.new NovelStatistics();

        // Call the averageTitleLength method and print the result
        double averageLength = statistics.averageTitleLength();
        System.out.println("Average title length: " + averageLength);

        BookStore<Literature> bookStore = new BookStore<>("Mixed Books Store", new ArrayList<>());

        // Step 2: Add novels and other types of literature to the bookstore
        bookStore.addItem(new Novel("1984"));
        bookStore.addItem(new ComicBook("Spider-Man"));
        bookStore.addItem(new Novel("Brave New World"));
        bookStore.addItem(new Magazine("National Geographic"));

        // Step 3: Create a collection to store novels
        List<Novel> novelCollection = new ArrayList<>();

        // Step 4: Invoke addNovelsToCollection method
        bookStore.addNovelsToCollection(novelCollection);

        // Step 5: Verify the results by printing the titles of the novels
        System.out.println("Novels added to the collection:");
        novelCollection.forEach(novel -> System.out.println(novel.getTitle()));






    }
}

