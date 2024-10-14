/**
 * Abstract parent class for various types of literature, such as Novel, ComicBook, and Magazine.
 * This class defines a common structure for all literary items and ensures that subclasses
 * implement the `getTitle()` method to retrieve the title of the item.
 *
 * @author Mitchell MacDonald & Hugo Amuan
 * @version 1.0
 */
public abstract class Literature {

    /**
     * Abstract method to retrieve the title of the literary item.
     * All subclasses (e.g., Novel, ComicBook, Magazine) must provide
     * their own implementation of this method.
     *
     * @return the title of the literary item as a String
     */
    public abstract String getTitle();
}
