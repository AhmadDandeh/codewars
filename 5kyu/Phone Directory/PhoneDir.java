class PhoneDir {
    public static  String phone(String strng, String num) {
        int index1 = strng.indexOf("+"+num);
        if(index1==-1){
            return "Error => Not found: "+num;
        }
        int index2 = strng.indexOf("+"+num, index1+1);
        if(index2>0){
            return "Error => Too many people: "+num;
        }
        int from = strng.substring(0, index1).lastIndexOf("\n");
        int to = strng.substring(0, index1).length()+strng.substring(index1).indexOf("\n");
        String info = strng.substring(from+1, to);
        info = info.replace("+"+num, "");
        String name = info.substring(info.indexOf("<")+1, info.indexOf(">"));
        info = info.replace("<"+name+">", "");
        info = info.trim();
        String addr="";
        for(int i=0;i<info.length();i++){
            char cChar = info.charAt(i);
            int c = (int) cChar;
            if((c>64 && c<91)||(c>96 && c<123)||(c>47)&&(c<58)||(c==45)||(c==46)){
                addr+=cChar;
            }
            if(c==32){
                if(!addr.isEmpty()){
                    if(addr.charAt(addr.length()-1)!=' '){
                        addr+=cChar;
                    }
                }
            }
            if(c==95){
                if(!addr.isEmpty()){
                    if(addr.charAt(addr.length()-1)!=' '){
                        addr+=' ';
                    }
                }
            }
        }
        return "Phone => "+num+", Name => "+name+", Address => "+addr.trim();
    }
}