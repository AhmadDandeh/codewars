public class Solution {

public static String generate_bc(String url, String separator) {
        String result = "";
        int index = url.indexOf("?");
        if (index != -1) {
            url = url.substring(0, index);
        }
        index = url.indexOf("#");
        if (index != -1) {
            url = url.substring(0, index);
        }
        index = url.indexOf("index");
        if (index != -1) {
            url = url.substring(0, index - 1);
        }
        if(url.charAt(url.length()-1)=='/'){
            url=url.substring(0, url.length()-1);
        }
        
        String notAllowded = " the of in from by with and or for to at a ";
        index = url.indexOf("/");
        if (index == -1) {
            return "<span class=\"active\">HOME</span>";
        }
        else if(("http:".equals(url.substring(0, index)))||("https:".equals(url.substring(0, index)))){
            index = url.indexOf("/",index+2);
            if (index == -1) {
                return "<span class=\"active\">HOME</span>";
            }
        }
        result += ("<a href=\"/\">HOME</a>" + separator);
        if(("http:".equals(url.substring(0, index)))||("https:".equals(url.substring(0, index)))){
            index = url.indexOf("/",index+2);
        }
        if(index==-1){
            url="";
        }
        else{
            url = url.substring(index + 1);
        }
        index = url.indexOf("/");
        String word = "";
        String wordH = "";
        String wordL= "";
        
        while (index != -1) {
            word = url.substring(0, index);
            wordH = "";
            if (word.length() > 30) {
                String[] words=word.split("-");
                for(String s:words){
                    if(!notAllowded.contains(" "+s+" ")){
                        wordH+=(s.charAt(0)+"").toUpperCase();
                    }
                }
            }
            else {
                wordH = word.toUpperCase();
                wordH=wordH.replaceAll("-", " ");
            }
            result += ("<a href=\""+wordL+"/" + word + "/\">" + wordH + "</a>" + separator);
            wordL += ("/"+word);
            url = url.substring(index + 1);
            index = url.indexOf("/");
        }

        index = url.indexOf(".");
        if (index == -1) {
            word=url;
        }
        else {
            word = url.substring(0, index);
        }
        
        wordH="";
        if (word.length() > 30) {
            String[] words=word.split("-");
            for(String s:words){
                if(!notAllowded.contains(" "+s+" ")){
                    wordH+=(s.charAt(0)+"").toUpperCase();
                }
            }
        }
        else {
            wordH = word.toUpperCase();
            wordH=wordH.replaceAll("-", " ");
        }
        result += ("<span class=\"active\">" + wordH + "</span>");

        return result;
    }
}