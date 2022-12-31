public class StripComments {
public static String stripComments(String text, String[] commentSymbols){
        if(text.isEmpty()){
            return text;
        }
        else{
            String[] split = text.split("\n");
            String result = "";
            for(String row: split){
                for(String symbole: commentSymbols){
                    int index = row.indexOf(symbole);
                    if(index>-1){
                        row = row.substring(0, index);
                    }
                }
                result += row.stripTrailing()+"\n";
            }
            return result.substring(0, result.length()-1);
        }
    }
}