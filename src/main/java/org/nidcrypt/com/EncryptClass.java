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
                        case 'w': if (currentRow > 0) currentRow--; break;
                        case 's': if (currentRow < mainMap.getGridHeight() - 1) currentRow++; break;
                        case 'a': if (currentCol > 0) currentCol--; break;
                        case 'd': if (currentCol < mainMap.getGridWidth() - 1) currentCol++; break;
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
