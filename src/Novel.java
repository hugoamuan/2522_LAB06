/**
 * The Novel class represents a book with a title, author name, and year of publication.
 * This class provides methods to retrieve the book's title, author, and year published.
 *
 * @author Mitchell MacDonald, Hugo Amuan
 * @version 1.0
 */
public class Novel extends Literature {

    private final String title;

    /**
     * Constructs a Novel object with the specified title, author, and year published.
     *
     * @param title the title of the novel
     */
    public Novel(final String title) {

        this.title = title;
    }

    /**
     * Retrieves the title of the novel.
     *
     * @return the title of the novel
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Returns a string representation of the Novel object, including the title,
     * author's name, and year published.
     *
     * @return a formatted string containing the novel's details
     */
    @Override
    public String toString() {
        return String.format("Title: %s", title);
    }

}