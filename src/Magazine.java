public class Magazine extends Literature {

    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    @Override
    public String getTitle(){
        return title;
    }
}
