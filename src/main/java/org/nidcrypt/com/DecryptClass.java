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
                        case 'w': if (currentRow < mainMap.getGridHeight() - 1) currentRow++; break;
                        case 's': if (currentRow > 0) currentRow--; break;
                        case 'a': if (currentCol < mainMap.getGridWidth() - 1) currentCol++; break;
                        case 'd': if (currentCol > 0) currentCol--; break;
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
