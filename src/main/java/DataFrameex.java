import joinery.DataFrame;
import java.io.IOException;
import java.util.Date;

public class DataFrameex {
    public static void main(String[] args) {

        try {
            System.out.println(DataFrame.readCsv("src/main/resourses/SPY.csv")
                    .retain("Date", "Close")
                    .groupBy(row -> Date.class.cast(row.get(0)).getMonth())
                    .mean()
                    .sortBy("Close")
                    .head(20)
                    .apply(value -> Number.class.cast(value).intValue())
                    .col("Close"));

            /*
            List<Number> lst = DataFrame.readCsv("HR_comma_sep2.csv")
                    .retain("Date", "Close")
                    .groupBy(new DataFrame.key <Object>() {
                        public Object apply(List<Object> row) {
                            return Date.class.cast(row.get(0)).getMonth();
                        }
                    }).mean()
                    .tail(20).col("close");
            System.out.println(lst);


             */
            }catch(IOException e){
                e.printStackTrace(); }
    }
}
