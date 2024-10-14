/**
 * The Magazine class represents a magazine with a title.
 * It extends the abstract class Literature, ensuring that a title is provided.
 * This class implements the abstract method `getTitle()` from the parent class.
 *
 * @author Mitchell MacDonald & Hugo Amuan
 * @version 1.0
 */
public class Magazine extends Literature {

    private final String title;

    /**
     * Constructs a Magazine object with the specified title.
     *
     * @param title the title of the magazine
     */
    public Magazine(final String title) {
        this.title = title;
    }

    /**
     * Retrieves the title of the magazine.
     *
     * @return the title of the magazine as a String
     */
    @Override
    public final String getTitle() {
        return title;
    }
}
