public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        if(seconds == 0){
            return "now";
        }
        int years=0, days=0, hours=0, minutes=0;
        
        years = seconds / 31536000;
        seconds %= 31536000;
        days = seconds / 86400;
        seconds %= 86400;
        hours = seconds/3600;
        seconds %= 3600;
        minutes = seconds / 60;
        seconds %= 60;
        
        String result = "";
        if(years != 0){
            if(years == 1){
                result += "1 year, ";
            }
            else{
                result += (years+" years, ");
            }
        }
             
        if(days != 0){
            if(days == 1){
                result += "1 day, ";
            }
            else{
                result += (days+" days, ");
            }
        }
        
        if(hours != 0){
            if(hours == 1){
                result += "1 hour, ";
            }
            else{
                result += (hours+" hours, ");
            }
        }
        
        if(minutes != 0){
            if(minutes == 1){
                result += "1 minute, ";
            }
            else{
                result += (minutes+" minutes, ");
            }
        }
        
        if(seconds != 0){
            if(seconds == 1){
                result += "1 second, ";
            }
            else{
                result += (seconds+" seconds, ");
            }
        }
        
        result = result.substring(0, result.length()-2);
        int lastComIndex = result.lastIndexOf(",");
        if(lastComIndex != -1){
            result = result.substring(0,lastComIndex)+" and"+result.substring(lastComIndex+1);
        }
        return result;
    }
}