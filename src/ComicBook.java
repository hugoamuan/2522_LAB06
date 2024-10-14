/**
 * The ComicBook class represents a comic book with a title.
 * It extends the abstract class Literature, ensuring that a title is provided.
 * This class implements the abstract method `getTitle()` from the parent class.
 *
 * @author Mitchell MacDonald & Hugo Amuan
 * @version 1.0
 */
public class ComicBook extends Literature {

    private final String title;

    /**
     * Constructs a ComicBook object with the specified title.
     *
     * @param title the title of the comic book
     */
    public ComicBook(final String title) {
        this.title = title;
    }

    /**
     * Retrieves the title of the comic book.
     *
     * @return the title of the comic book as a String
     */
    @Override
    public final String getTitle() {
        return title;
    }
}
