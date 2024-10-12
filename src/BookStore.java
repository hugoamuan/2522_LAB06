import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The BookStore class represents a collection of novels and provides various methods
 * to search, sort, and retrieve information about the books in the store.
 *
 * @author Mitchell MacDonald, Hugo Amuan
 * @version 1.0
 */
public class BookStore<T extends Literature> {

    static class BookStoreInfo {

        public void displayInfo(final String storeName,
                                final int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }

    }

        // Example code
        private final List<T> items = new ArrayList<>();

        class NovelStatistics {

            public static final int START_LENGTH = 0;

            public double averageTitleLength() {
                int totalLength = START_LENGTH;
                for (T item : items) {
                    totalLength += item.getTitle().length();
                }
                return (double) totalLength / items.size();
            }
        }


        private static final int START_INDEX = 0;
        private static final int INDEX_OFFSET = 1;
        private static final int FIRST_BOOK_NUM = 1;
        private static final int FIRST_BOOK_FOUND = 1;
        private static final int DECADE_OFFSET = 9;
        private static final int DECIMAL_OFFSET = 100;
        private final List<Novel> novels;
        private final List<ComicBook> comics;
        private final List<Magazine> magazines;

        /**
         * Constructs a BookStore object and populates it with a list of novels.
         *
         * @param bookStoreName the name of the bookstore
         */
        public BookStore(final String bookStoreName, List<Literature> comic) {

            this.magazines = new ArrayList<>();
            this.comics = new ArrayList<>();
            this.novels = new ArrayList<>();

        }

        /**
         * Prints all the titles of the novels in the bookstore in uppercase,
         * preceded by their book number.
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
         * @return a formatted string of matching book titles, or a message indicating no matches were found
         */
        public final String printBookTitle(final String searchParam) {


            items.forEach(item -> {
                if(item.getTitle().contains(searchParam))
                {
                    System.out.println(item.getTitle());
                }
            });


            final StringBuilder result;
            int bookNumber;
            boolean foundMatch;
            String currentTitle;

            result = new StringBuilder();
            bookNumber = FIRST_BOOK_FOUND;
            foundMatch = false;

            for (final Novel novel : novels) {
                currentTitle = novel.getTitle();

                if (currentTitle.toLowerCase().contains(searchParam.toLowerCase())) {
                    foundMatch = true;
                    result.append(bookNumber).append(". ").append(currentTitle).append("\n");
                    bookNumber++;
                }
            }
            return foundMatch ? result.toString().trim() : "No matching titles found for: " + searchParam;
        }

    public void addNovelsToCollection(final List<? super Novel> novelCollection) {
        for (T item : items) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }

        /**
         * Returns a formatted string of all book titles in alphabetical order.
         *
         * @return a string containing the titles of all novels in the bookstore, sorted alphabetically
         */
    public void printTitlesInAlphaOrder() {

            // Sort the list by comparing the titles using a method reference
            items.sort(Comparator.comparing(T::getTitle, String::compareToIgnoreCase));

            // Print each item's title in alphabetical order
            items.forEach(item -> System.out.println(item.getTitle()));
        }




        /**
             * Counts how many books contain the specified search parameter in their title.
             *
             * @param searchParam the string to search for in the titles of the novels
             * @return the number of books that contain the search parameter in their title
             */
        public final int howManyBooksContain(final String searchParam) {

            int count = START_INDEX;

            for (final Novel novel : novels) {
                if (novel.getTitle().toLowerCase().contains(searchParam.toLowerCase())) {
                    count++;
                }
            }
            return count;
        }


        /**
         * Retrieves the title of the novel with the longest title in the bookstore.
         *
         * @return the title of the longest novel, or a message indicating no books are in the bookstore
         */
        public final String getLongest() {

            String longestTitle;
            String currentTitle;

            longestTitle = "";

            if (novels.isEmpty()) {
                return "No books in the bookstore.";
            }

            for (final Novel novel : novels) {
                currentTitle = novel.getTitle();

                if (currentTitle.length() > longestTitle.length()) {
                    longestTitle = currentTitle;
                }
            }
            return longestTitle;
        }

        /**
         * Returns a list of novels whose title length matches the specified length.
         *
         * @param titleLength the exact length of the titles to search for
         * @return a list of novels that have titles of the specified length
         */
        public final List<Novel> getBooksThisLength(final int titleLength) {

            final List<Novel> matchingNovels;

            matchingNovels = new ArrayList<>();

            for (final Novel novel : novels) {
                if (novel.getTitle().length() == titleLength) {
                    matchingNovels.add(novel);
                }
            }

            return matchingNovels;
        }


        public void addItem(final T item) {
            items.add(item);
        }

        public void printItems() {
            for (final T item : items) {
                System.out.println(item.getTitle());
            }
        }


}