public class ComicBook extends Literature {

    private String title;

    public ComicBook(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
