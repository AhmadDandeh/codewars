public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {
        if(s.length()!=part1.length()+part2.length()){
            return false;
        }
        
        int index1=0, index2=0, index3=0, offset=0;
        String part3="";
        
        for(int i=0;i<s.length();i++){
            if(offset>0){
                if(index1==part1.length()){
                    if(index2==part2.length()){
                        if(s.charAt(i)==part3.charAt(0)){
                            part3=part3.substring(1);
                            index3--;
                            offset--;
                        }
                        else{
                            return false;
                        }
                    }
                    else if(s.charAt(i)==part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                        
                    }
                    else if(s.charAt(i)==part2.charAt(index2)&&s.charAt(i)!=part3.charAt(0)){
                        index2++;
                    }
                    else if(s.charAt(i)!=part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                        offset--;
                        part3=part3.substring(1);
                        index3--;
                    }
                    else{
                        return false;
                    }
                }
                else if(index2==part2.length()){
                    if(index1==part1.length()){
                        if(s.charAt(i)==part3.charAt(0)){
                            part3=part3.substring(1);
                            index3--;
                            offset--;
                        }
                        else{
                            return false;
                        }
                    }
                    else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)==part3.charAt(0)){
                        
                    }
                    else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)!=part3.charAt(0)){
                        index1++;
                    }
                    else if(s.charAt(i)!=part1.charAt(index1)&&s.charAt(i)==part3.charAt(0)){
                        offset--;
                        part3=part3.substring(1);
                        index3--;
                    }
                    else{
                        return false;
                    }                    
                }
                else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)==part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                    index1++;
                    index2++;
                    offset++;
                    index3++;
                    part3+=s.charAt(i);
                }
                else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)==part2.charAt(index2)&&s.charAt(i)!=part3.charAt(0)){
                    index1++;
                    index2++;
                    offset++;
                    index3++;
                    part3+=s.charAt(i);
                }
                else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)!=part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                    
                }
                else if(s.charAt(i)!=part1.charAt(index1)&&s.charAt(i)==part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                    
                }
                else if(s.charAt(i)==part1.charAt(index1)&&s.charAt(i)!=part2.charAt(index2)&&s.charAt(i)!=part3.charAt(0)){
                    index1++;
                    index2-=offset;
                    offset=0;
                    part3="";
                    index3=0;
                }
                else if(s.charAt(i)!=part1.charAt(index1)&&s.charAt(i)==part2.charAt(index2)&&s.charAt(i)!=part3.charAt(0)){
                    index2++;
                    index1-=offset;
                    offset=0;
                    part3="";
                    index3=0;
                }
                else if(s.charAt(i)!=part1.charAt(index1)&&s.charAt(i)!=part2.charAt(index2)&&s.charAt(i)==part3.charAt(0)){
                    offset--;
                    index3--;
                    part3=part3.substring(1);
                }
                else{
                    return false;
                }
            }
            else{
                if(index1==part1.length()){
                    if(s.charAt(i)==part2.charAt(index2)){
                        index2++;
                    }
                    else{
                        return false;
                    }
                }
                else if(index2==part2.length()){
                    if(s.charAt(i)==part1.charAt(index1)){
                        index1++;
                    }
                    else{
                        return false;
                    }
                }
                else if(s.charAt(i)==part1.charAt(index1)&&(s.charAt(i)==part2.charAt(index2))){
                    index1++;
                    index2++;
                    index3++;
                    offset++;
                    part3+=s.charAt(i);
                }
                else if(s.charAt(i)==part1.charAt(index1)&&(s.charAt(i)!=part2.charAt(index2))){
                    index1++;
                }
                else if(s.charAt(i)!=part1.charAt(index1)&&(s.charAt(i)==part2.charAt(index2))){
                    index2++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    
}