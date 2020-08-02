package in.mangaldeep;

public class carditem {
    private int mImageResource;
    private String mText;

    public carditem(int ImageResorce , String Text ){
        mImageResource = ImageResorce;
        mText = Text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
