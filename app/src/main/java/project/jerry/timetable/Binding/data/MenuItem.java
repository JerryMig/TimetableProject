package project.jerry.timetable.Binding.data;

/**
 * Created by Migme_Jerry on 2017/4/11.
 */

public class MenuItem {

    private String mItemName;
    private boolean mHasNextPage;
    private boolean mHasPrePage;

    public MenuItem(String name, boolean nextPage) {
        mItemName = name;
        mHasNextPage = nextPage;
    }

    public MenuItem(String name) {
        mItemName = name;
        mHasNextPage = false;
    }

    public void setHasNextPage(boolean hasNextPage) {
        mHasNextPage = hasNextPage;
    }

    public boolean hasNextPage() {
        return mHasNextPage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        mHasPrePage = hasPrePage;
    }

    public boolean hasPrePage() {
        return mHasPrePage;
    }

    public String getItemName() {
        return mItemName;
    }

}
