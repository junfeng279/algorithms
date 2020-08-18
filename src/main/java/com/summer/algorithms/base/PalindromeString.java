package com.summer.algorithms.base;

/**
 * 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 * 那么，我们的第一个问题就是：判断一个字串是否是回文？
 *
 * @author adminstor
 */
public class PalindromeString {
    public static void main(String[] args) {
        String str = "maam";
        System.out.println(isPalindrome(str, str.length()));
        System.out.println(getStrMiddleIndex(str));
        System.out.println(isPalindrome1(str, str.length()));
    }

    /**
     * 方法 1
     * 同时从字符串头尾开始向中间扫描字串，如果所有字符都一样，那么这个字串就是一个回文。
     * 采用这种方法的话，我们只需要维护头部和尾部两个扫描指针即可
     *
     * @param str 需要检测的字符串
     * @param n   字符串长度
     * @return 是否是回文字符串
     */
    private static boolean isPalindrome(String str, int n) {
        if (str == null || n < 1) {
            return false;
        }
        char[] chars = str.toCharArray();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 方法 1
     * 上述解法一从两头向中间扫描，那么是否还有其它办法呢？
     * 我们可以先从中间开始、然后向两边扩展查看字符是否相等
     *
     * @param str 需要检测的字符串
     * @param n 字符串长度
     * @return 是否是回文字符串
     */
    private static boolean isPalindrome1(String str, int n) {
        if (str == null || n < 1) {
            return false;
        }
        char[] chars = str.toCharArray();
        int middle = getStrMiddleIndex(str);
        int first,second;
        if(middle==0){
            first = str.length()/2-1;
            second = str.length()/2;
        }else if(middle == -1){
            return false;
        }else{
            first = middle;
            second = middle;
        }
        while(first>0 && second<n){
            if(chars[first]!=chars[second]){
                return false;
            }
            first--;
            second++;
        }
        return true;
    }

    private static int getStrMiddleIndex(String str){
        if(str == null){
            return -1;
        }
        if(str.length()%2==0){
            return 0;
        }else{
            return str.length()/2;
        }
    }

}
