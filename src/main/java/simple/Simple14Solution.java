package simple;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple14Solution {
    public static void main(String[] args) {
        String[] test = {"flower", "flow", "flight"};
        String v = longestCommonPrefix(test);
        System.out.println(v);
    }
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String longestCommonPrefix = "";
        for (int i = 0; i < strs.length; i++) {
            longestCommonPrefix = getLongestCommonPrefix(longestCommonPrefix, strs[i]);
            if (longestCommonPrefix.length() == 0) {
                return "";
            }
        }
        return longestCommonPrefix;
    }

    private static   String getLongestCommonPrefix(String str1, String str2) {
        if(str1.length()==0) return str2;
        int subIndex = 0;
        int length = str1.length() > str2.length() ? str2.length() : str1.length();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                subIndex++;
            } else {
                break;
            } 
        }
        return subIndex==0?"":str1.length()>str2.length()?str1.substring(0,subIndex):str2.substring(0,subIndex);    
    }

}
