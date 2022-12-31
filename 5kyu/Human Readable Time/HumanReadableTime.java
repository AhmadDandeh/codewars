public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int HH=seconds/3600;
        seconds%=3600;
        int MM=seconds/60;
        seconds%=60;
        return (HH<10?"0"+HH:HH)+":"+(MM<10?"0"+MM:MM)+":"+(seconds<10?"0"+seconds:seconds);
    }
}