public class DateTimeFormater {
    public static String format(String formatStr, int... values) {
        String output = "";

        if(formatStr.equals("D")) {
            if(values.length == 3) {
                for(int i = 0; i < values.length; i++) {
                    output += String.format("%s%d", values[i] < 10 ? "0" : "", values[i]);
                    output += i < values.length - 1 ? "." : "";
                }
            } else {
                throw new NumberFormatException("Sie müssen beim Datum 3 Parameter haben!");
            }
        } else if(formatStr.equals("T")) {
            if(values.length == 2) {
                for(int i = 0; i < values.length; i++) {
                    output += String.format("%s%d", values[i] < 10 ? "0" : "", values[i]);
                    output += i < values.length - 1 ? ":" : "";
                }
            } else {
                throw new NumberFormatException("Sie müssen bei der Uhrzeit 2 Parameter haben!");
            }
        } else {
            if(values.length == 5) {
                for(int i = 0; i < values.length - 2; i++) {
                    output += String.format("%s%d", values[i] < 10 ? "0" : "", values[i]);
                    output += i < values.length - 3 ? "." : "";
                }

                output += " - ";

                for(int i = 3; i < values.length; i++) {
                    output += String.format("%s%d", values[i] < 10 ? "0" : "", values[i]);
                    output += i < values.length - 1 ? ":" : "";
                }
            } else {
                throw new NumberFormatException("Sie müssen beim Datum und der Uhrzeit 5 Parameter haben!");
            }
        }

        return output;
    }
}
