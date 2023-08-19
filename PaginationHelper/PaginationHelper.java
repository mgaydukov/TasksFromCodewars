//https://www.codewars.com/kata/515bb423de843ea99400000a/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginationHelper<T> {

    private ArrayList<T> collection;
    private int itemsPerPage;

    public PaginationHelper(List<T> collection, int itemsPerPage) {
        this.collection = new ArrayList<>(collection);
        this.itemsPerPage = itemsPerPage;
    }

    // returns the number of items within the entire collection
    public int itemCount() {
        return collection.size();
    }

    //returns the number of pages
    public int pageCount() {
        if(collection.size()%itemsPerPage == 0)
            return collection.size()/itemsPerPage;
        else
            return collection.size()/itemsPerPage + 1;
    }

    public int pageItemCount(int pageIndex) {
        if(pageIndex < 0  || pageIndex > pageCount()-1)
            return -1;
        else if(pageIndex == pageCount()-1)
            return collection.size()%itemsPerPage;
        else
            return itemsPerPage;
    }

    public int pageIndex(int itemIndex) {
        if(itemIndex < 0  || itemIndex > collection.size()-1)
            return -1;
        else if(itemIndex % itemsPerPage == 0 && itemIndex != 0)
            return itemIndex/itemsPerPage-1;
        else
            return itemIndex/itemsPerPage;
    }

    public static void main(String[] args) {

        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid


        System.out.println(helper.pageIndex(5)); // should == 1
        System.out.println(helper.pageIndex(2)); // should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }
}