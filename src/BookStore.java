import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The BookStore class represents a collection of literary items (e.g. novels, comics, magazines)
 * and provides various methods to search, sort, and retrieve information about the books in the store.
 *
 * @param <T> The type of literature, restricted to classes that extend Literature.
 * @version 1.0
 * @author Mitchell MacDonald, Hugo Amuan
 */
public class BookStore<T extends Literature> {

    /**
     * Inner class to display general information about the bookstore.
     */
    static class BookStoreInfo {
        /**
         * Displays the bookstore's name and the number of items it contains.
         *
         * @param storeName the name of the bookstore
         * @param itemCount the total number of items in the store
         */
        public void displayInfo(final String storeName,
                                final int itemCount){
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    private final List<T> items = new ArrayList<>();

    /**
     * Inner class to provide statistics related to the novels in the store.
     */
    public class NovelStatistics {

        private static final int START_LENGTH = 0;

        /**
         * Calculates the average length of the titles of all literature items.
         *
         * @return the average length of the titles as a double
         */
        public final double averageTitleLength() {

            int totalLength;

            totalLength = START_LENGTH;

            for(final T item : items)
            {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }
    }

    // Constants for index offsets and formatting values.
    private static final int START_INDEX = 0;
    private static final int FIRST_BOOK_NUM = 1;
    private static final int FIRST_BOOK_FOUND = 1;

    // Lists to store specific types of literature.
    private final List<Novel> novels;
    private final List<ComicBook> comics;
    private final List<Magazine> magazines;

    /**
     * Constructs a BookStore object and initializes the lists for different types of literature.
     *
     * @param bookStoreName the name of the bookstore
     */
    public BookStore(final String bookStoreName, List<Literature> comic) {
        this.magazines = new ArrayList<>();
        this.comics = new ArrayList<>();
        this.novels = new ArrayList<>();
    }

    /**
     * Prints all the titles of the novels in uppercase, preceded by their book number.
     */
    public final void printAllTitles() {

        final StringBuilder result;

        int bookNumber;

        result = new StringBuilder();
        bookNumber = FIRST_BOOK_NUM;

        for(final Novel novel : novels)
        {
            result.append(bookNumber).append(". ").append(novel.getTitle().toUpperCase()).append("\n");
            bookNumber++;
        }
        System.out.println("Novel titles: \n" + result);
    }

    /**
     * Searches for novels whose titles contain the specified search parameter.
     *
     * @param searchParam the string to search for in the titles of the novels
     * @return a formatted string of matching book titles or a message indicating no matches
     */
    public final String printBookTitle(final String searchParam) {

        items.forEach(item ->
        {
            if(item.getTitle().contains(searchParam))
            {
                System.out.println(item.getTitle());
            }
        });

        final StringBuilder result;
        int bookNumber;
        boolean foundMatch;

        result = new StringBuilder();

        bookNumber = FIRST_BOOK_FOUND;
        foundMatch = false;

        for(final Novel novel : novels)
        {
            String currentTitle;

            currentTitle = novel.getTitle();

            if(currentTitle.toLowerCase().contains(searchParam.toLowerCase()))
            {
                foundMatch = true;
                result.append(bookNumber).append(". ").append(currentTitle).append("\n");
                bookNumber++;
            }
        }
        return foundMatch ? result.toString().trim() : "No matching titles found for: " + searchParam;
    }

    /**
     * Adds novels from the items list to a given novel collection.
     *
     * @param novelCollection the collection to which novels will be added
     */
    public final void addNovelsToCollection(final List<? super Novel> novelCollection) {

        for(final T item : items)
        {
            if(item instanceof Novel)
            {
                novelCollection.add((Novel) item);
            }
        }
    }

    /**
     * Prints the titles of all items in the bookstore in alphabetical order.
     */
    public final void printTitlesInAlphaOrder() {

        items.sort(Comparator.comparing(T::getTitle, String::compareToIgnoreCase));
        items.forEach(item -> System.out.println(item.getTitle()));
    }

    /**
     * Counts how many novels contain the specified search parameter in their title.
     *
     * @param searchParam the string to search for in the titles of the novels
     * @return the number of matching books
     */
    public final int howManyBooksContain(final String searchParam) {

        int count;
        count = START_INDEX;

        for(final Novel novel : novels)
        {
            if(novel.getTitle().toLowerCase().contains(searchParam.toLowerCase()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Retrieves the title of the novel with the longest title.
     *
     * @return the longest title or a message if the store is empty
     */
    public final String getLongest() {

        String longestTitle;
        longestTitle = "";

        if(novels.isEmpty())
        {
            return "No books in the bookstore.";
        }
        for(final Novel novel : novels)
        {
            String currentTitle;
            currentTitle = novel.getTitle();
            if(currentTitle.length() > longestTitle.length())
            {
                longestTitle = currentTitle;
            }
        }
        return longestTitle;
    }

    /**
     * Retrieves a list of novels with titles matching the specified length.
     *
     * @param titleLength the desired title length
     * @return a list of novels with matching title length
     */
    public final List<Novel> getBooksThisLength(final int titleLength){

        final List<Novel> matchingNovels;
        matchingNovels = new ArrayList<>();

        for(final Novel novel : novels)
        {
            if(novel.getTitle().length() == titleLength)
            {
                matchingNovels.add(novel);
            }
        }
        return matchingNovels;
    }

    /**
     * Adds a new item to the bookstore's collection.
     *
     * @param item the item to be added
     */
    public void addItem(final T item) {
        items.add(item);
    }

    /**
     * Prints the titles of all items in the bookstore.
     */
    public void printItems() {

        for(final T item : items)
        {
            System.out.println(item.getTitle());
        }
    }
}
