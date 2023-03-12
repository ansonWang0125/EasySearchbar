package sdm.hw2.com.example.RequestObj;

public class SearchObject {
    private String searchStr;

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }


    @Override
    public String toString() {
        return "SearchObject [searchStr=" + searchStr + "]";
    }
}
