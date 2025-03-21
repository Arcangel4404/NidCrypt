package org.nidcrypt.com;

public class NidCrypt {
    public static void main(String[] args) {
        MainMap mainMap = new MainMap();
        mainMap.printGrid();
        InputForMap inputForMap = new InputForMap(mainMap);
        inputForMap.start();
    }
}
