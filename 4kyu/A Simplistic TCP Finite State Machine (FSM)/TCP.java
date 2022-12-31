import java.util.HashMap;

public class TCP {
        private static HashMap<String, Integer> hMap=new HashMap<>();
    private static String[][] nextPara = new String[11][];
    private static String[][] nextRes = new String[11][];
    
    public static String traverseStates(String[] events) {
        if(events.length == 0){
            return "ERROR";
        }
        else{
            hMap.clear();
            initialize();
            String state = "CLOSED";
            int index = hMap.getOrDefault(state, -1);
            for(String eve: events){
                if(index == -1){
                    return "ERROR";
                }
                else{
                    boolean trueProssess = false;
                    for(int i =0; i<nextPara[index].length; i++){
                        if(nextPara[index][i].equals(eve)){
                            state = nextRes[index][i];
                            trueProssess = true;
                            break;
                        }
                    }
                    if(!trueProssess){
                        return "ERROR";
                    }
                    else{
                        index = hMap.getOrDefault(state, -1);
                    }
                }
            }
            return state;
        }
    }

    private static void initialize() {
        // 0
        hMap.put("CLOSED",0);
        nextPara[0] = new String[]{"APP_PASSIVE_OPEN", "APP_ACTIVE_OPEN"};
        nextRes[0] = new String[]{"LISTEN", "SYN_SENT"};
        // 1
        hMap.put("LISTEN",1);
        nextPara[1] = new String[]{"RCV_SYN", "APP_SEND", "APP_CLOSE"};
        nextRes[1] = new String[]{"SYN_RCVD", "SYN_SENT", "CLOSED"};
        //2
        hMap.put("SYN_RCVD",2);
        nextPara[2] = new String[]{"APP_CLOSE", "RCV_ACK"};
        nextRes[2] = new String[]{"FIN_WAIT_1", "ESTABLISHED"};
        //3
        hMap.put("SYN_SENT",3);
        nextPara[3] = new String[]{"RCV_SYN", "RCV_SYN_ACK", "APP_CLOSE"};
        nextRes[3] = new String[]{"SYN_RCVD", "ESTABLISHED", "CLOSED"};
        //4
        hMap.put("ESTABLISHED",4);
        nextPara[4] = new String[]{"APP_CLOSE", "RCV_FIN"};
        nextRes[4] = new String[]{"FIN_WAIT_1", "CLOSE_WAIT"};
        //5
        hMap.put("FIN_WAIT_1",5);
        nextPara[5] = new String[]{"RCV_FIN", "RCV_FIN_ACK", "RCV_ACK"};
        nextRes[5] = new String[]{"CLOSING", "TIME_WAIT", "FIN_WAIT_2"};
        //6
        hMap.put("CLOSING",6);
        nextPara[6] = new String[]{"RCV_ACK"};
        nextRes[6] = new String[]{"TIME_WAIT"};
        //7
        hMap.put("FIN_WAIT_2",7);
        nextPara[7] = new String[]{"RCV_FIN"};
        nextRes[7] = new String[]{"TIME_WAIT"};
        //8
        hMap.put("TIME_WAIT",8);
        nextPara[8] = new String[]{"APP_TIMEOUT"};
        nextRes[8] = new String[]{"CLOSED"};
        //9
        hMap.put("CLOSE_WAIT",9);
        nextPara[9] = new String[]{"APP_CLOSE"};
        nextRes[9] = new String[]{"LAST_ACK"};
        //10
        hMap.put("LAST_ACK",10);
        nextPara[10] = new String[]{"RCV_ACK"};
        nextRes[10] = new String[]{"CLOSED"};
    }

}