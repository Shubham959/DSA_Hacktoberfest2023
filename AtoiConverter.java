public class AtoiConverter {
    public static int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1; // 1 for positive, -1 for negative
        int result = 0;

        // Skip leading whitespace characters
        while (index < str.length() && Character.isWhitespace(str.charAt(index))) {
            index++;
        }

        // Check for an optional sign
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = (str.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            
            // Check for integer overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        String str = "12345"; // Replace this with your input string
        int result = atoi(str);
        System.out.println("The integer value is: " + result);
    }
}
