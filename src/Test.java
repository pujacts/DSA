import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {

        DecimalFormat df=new DecimalFormat("#,###");

        Number d = 200000000;
        String formattedNumberWithComma = df.format(d);
        formattedNumberWithComma = formattedNumberWithComma.replace(","," ")+"puj";
        System.out.println("Formatted number with commas: "+formattedNumberWithComma);
        Number[] numbers = {200000000, 20000000, 2000000, 2000, 200, 20, 2,0};
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        //decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(4);
        System.out.println("adding commas to number in Java using DecimalFormat class");
        for (Number n : numbers) {
            String format = decimalFormat.format(n);
            String[] values = format.split(",");
            DecimalFormat decimalFormat1 = new DecimalFormat("#,###");
            String result = "";
            for(int i=0; i< values.length-1; i++){
                result = result + values[i];
                result = decimalFormat1.format(Double.parseDouble(result));
                result = result.replace(","," ");
            }
            if(result!="") {
                result = result + "," + values[values.length - 1];

            }
            else
                result = result + values[values.length-1];
            System.out.println(result); }

    }
}
