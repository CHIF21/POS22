public class DateTimeFormater {

    public static String format(String formatString, int... values) throws Exception {
        String output = "";

        if(formatString.equals("DT")) {
            if (values.length == 5) {
                for (int i = 0; i < values.length; i++) {
                    if (i + 1 <= 2) {
                        output += String.format("%02d-", values[i]);
                    }
                    if (i + 1 == 3) {
                        output += String.format("%d - ", values[i]);
                    }
                    if (i + 1 == 4) {
                        output += String.format("%02d:", values[i]);
                    } else if (i + 1 == values.length) {
                        output += String.format("%02d", values[i]);
                    }
                }
            } else {
                throw new Exception("You need five parameters!");
            }
        }

        if(formatString.equals("D")){
            if(values.length == 3)
            {
                for (int i = 0; i < values.length; i++) {
                    if(i < values.length - 1){
                        output += String.format("%02d-",values[i]);
                    }
                    else{
                        output += String.format("%d",values[i]);
                    }
                }
            }
            else{
                throw new Exception("You need three parameters!");
            }
        }

        if(formatString.equals("T")){
            if(values.length == 2){
                for (int i = 0; i < values.length; i++) {
                    if(i < values.length - 1){
                        output += String.format("%02d:",values[i]);
                    }
                    else{
                        output += String.format("%02d",values[i]);
                    }
                }
            }
            else{
                throw new Exception("You need two parameters!");
            }
        }
        return output;
    }
}
