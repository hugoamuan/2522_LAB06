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
        library.addItem(new ComicBook("Spider-Man"));
        library.addItem(new Magazine("National Geographic"));

        library.printItems();

        System.out.println("\nAlpha Order: ");
        library.printTitlesInAlphaOrder();



    }
}

