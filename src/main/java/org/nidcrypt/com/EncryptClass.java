package org.nidcrypt.com;

public class EncryptClass {
    private final MainMap mainMap;

    public EncryptClass(MainMap mainMap) {
        this.mainMap = mainMap;
    }

    public String encryptString(String input, String directions) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int[] position = mainMap.findLetterPosition(ch);
            if (position != null) {
                int currentRow = position[0];
                int currentCol = position[1];

                for (char direction : directions.toCharArray()) {
                    switch (direction) {
                        case 'w': 
                            currentRow = (currentRow == 0) ? mainMap.getGridHeight() - 1 : currentRow - 1;
                            break;
                        case 's': 
                            currentRow = (currentRow == mainMap.getGridHeight() - 1) ? 0 : currentRow + 1;
                            break;
                        case 'a': 
                            currentCol = (currentCol == 0) ? mainMap.getGridWidth() - 1 : currentCol - 1;
                            break;
                        case 'd': 
                            currentCol = (currentCol == mainMap.getGridWidth() - 1) ? 0 : currentCol + 1;
                            break;
                    }
                }
                result.append(mainMap.getLetter(currentRow, currentCol));
            } else {
                result.append('?');
            }
        }
        return result.toString();
    }
}
