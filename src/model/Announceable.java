package model;

public interface Announceable{

    /**
     * Displays advertisements based on the product type and the page count.
     * 
     * @param productType The type of product for which the ads are displayed.
     * @param pagesCount The product's page count read.
     * @return A string containing the displayed ad.
     */
    public abstract String displayAds(int productType, int pagesCount);

}