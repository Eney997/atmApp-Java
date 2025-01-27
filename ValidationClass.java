public class ValidationClass {
    //---------------------------------------------------------------------------CHECKS IF THERES NUMBER IN STRING INPUT
    public static int containsOnlyLetters(String str) {
        // run in characters of the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))) {
                return 1; // Return 1 if num found
            }
        }
        return 0; // Return 0 if all good
    }
    //------------------------------------------------------------------------------------------CHECKS IF INPUT IS EMPTY
    public static int emptyInput(String str) {
        if (str == null || str.isEmpty()) {
            return 1; // Return 1 for invalid input
        }
        else
        {
            return 0;
        }
    }
    //----------------------------------------------CHECKS IF FIRS LETTER IS UPPERCASE OR NOT IN NAME AND LASTNAME INPUT
    public static int capitalLetterFirst(String str)
    {
        char firstChar = str.charAt(0);
        if (firstChar < 65 || firstChar > 90) {
            return 1;
        }
        return 0;
    };
    //--------------------------------------------DOES NOT ALLOWS UPPERCASE AFTER FIRS LETTER IN NAME AND LASTNAME INPUT
    public static int fullStringCantBeCapital(String str)
    {

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar >= 65 && currentChar <= 90) {
                return 1;
            }
        }
        return 0;
    }
    //-------------------------------------------------------------------------------DOESNOT ALLOWS SPACE IN EVERY INPUT
    public static int forbidSpace(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == 32) {
                return 1;
            }
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------COUNT LETTERS 7
    public static int minimumLengthForUserName(String str)
    {
        int minimum = 7;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen < minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------COUNT LETTERS 3
    public static int minimumThre(String str)
    {
        int minimum = 3;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen != minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------COUNT LETTERS 2
    public static int minimumTwo(String str)
    {
        int minimum = 2;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen != minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //--------------------------------------------------------------------------------------------------COUNT LETTERS 16
    public static int minimumSixTeen(String str)
    {
        int minimum = 16;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen != minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------COUNT LETTERS 6
    public static int minimumSix(String str)
    {
        int minimum = 6;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen != minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //-----------------------------------------------------IN USERNAME INPUT ALLOWS TO BE ENTERED ONLY NUMBER AND LETTER
    public static int userCanWriteOnlyNumAndLet(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122 || (ch) >= 48 && ch <= 57)))
            {
                return 1;
            }
        }
        return 0;
    }
    //-----------------------------------------------------------------PASSWORD MUST CONTAIN NUMBER LETTER AND CHARACTER
    public static int passwordMust(String str) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }
        //If all conditions are met, return 1 (valid)
        if (hasLetter && hasDigit && hasSpecialChar) {
            return 0;
        }
        // Otherwise, return 0 (invalid)
        return 1;
    }
    //---------------------------------------------------------------------------------------------CONTAINS ONLY NUMBERS
    public static boolean  containsOnlyNumbers(String str)
    {
        if (str != null && str.matches("[0-9]+")) {
            return true; // The string contains only numbers
        }
        return false;
    }
    //-------------------------------------------------------------------convert inputed string into integer and compare
    public static int convertYear(String str)
    {
        int stringValueToInt = Integer.parseInt(str);

        if(stringValueToInt < 25)
        {
            return 1;
        }
        return 0;
    }
    //-------------------------------------------------------------------convert inputed string into integer and compare
    public static int convertMonth(String str)
    {
        int stringValueToInt = Integer.parseInt(str);

        if(stringValueToInt == 0 || stringValueToInt > 12 )
        {
            return 1;
        }
        return 0;
    }
    //-------------------------------------------------------------MINIMUM AMOUNT FOR DEPOSIT MONEY maxAmountForDeposite
    public static int maxAmountForDeposite(String str)
    {
        int stringValueToInt = Integer.parseInt(str);

        if(stringValueToInt == 0 || stringValueToInt > 5000 )
        {
            return 1;
        }
        return 0;
    }
    //------------------------------------------------------------------------------------------DEPOSITEAMOUNT MAXNUMBER
    public static int depositAmountMaxNumber(String str)
    {
        int minimum = 6;
        int currecntStrLen = str.length();
        for(int i = 0;i<currecntStrLen;i++)
        {
            if(currecntStrLen > minimum)
            {
                return 1;
            }
        }
        return 0;
    }
    //--------------------------------------------------------------------------------------------FIRST NUM CANT BE ZERO
    public static int forbidFirstNumZero(String str)
    {
        char firstChar = str.charAt(0);
        if (firstChar == 48 ) {
            return 1;
        }
        return 0;
    };
}