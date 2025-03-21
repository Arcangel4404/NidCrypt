package org.nidcrypt.com;

public class DecryptClass {
    private final MainMap mainMap;

    public DecryptClass(MainMap mainMap) {
        this.mainMap = mainMap;
    }

    public String decryptString(String encryptedText, String directions) {
        StringBuilder result = new StringBuilder();

        for (char ch : encryptedText.toCharArray()) {
            int[] position = mainMap.findLetterPosition(ch);
            if (position != null) {
                int currentRow = position[0];
                int currentCol = position[1];

                for (int i = directions.length() - 1; i >= 0; i--) {
                    switch (directions.charAt(i)) {
                        case 'w': 
                            currentRow = (currentRow == mainMap.getGridHeight() - 1) ? 0 : currentRow + 1;
                            break;
                        case 's': 
                            currentRow = (currentRow == 0) ? mainMap.getGridHeight() - 1 : currentRow - 1;
                            break;
                        case 'a': 
                            currentCol = (currentCol == mainMap.getGridWidth() - 1) ? 0 : currentCol + 1;
                            break;
                        case 'd': 
                            currentCol = (currentCol == 0) ? mainMap.getGridWidth() - 1 : currentCol - 1;
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
