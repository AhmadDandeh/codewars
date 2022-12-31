import java.util.List;

public class PaginationHelper<I> {

    private int itemsPerPage;
    private List<I> collection;
    private int numberOfPages;

    /**
     * The constructor takes in an array of items and a integer indicating how
     * many items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemsPerPage=itemsPerPage;
        this.collection=collection;
        this.numberOfPages=(collection.size()/itemsPerPage)+1;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.numberOfPages;
    }

    /**
     * returns the number of items on the current page. page_index is zero
     * based. this method should return -1 for pageIndex values that are out of
     * range
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex<0 || pageIndex>=this.numberOfPages){
            return -1;
        }
        else if(pageIndex==this.numberOfPages-1){
            return this.collection.size()%this.itemsPerPage;
        }
        else{
            return this.itemsPerPage;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes this method should
     * return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex<0 || itemIndex>=this.collection.size()){
            return -1;
        }
        else{
            return itemIndex/this.itemsPerPage;
        }
    }
}
