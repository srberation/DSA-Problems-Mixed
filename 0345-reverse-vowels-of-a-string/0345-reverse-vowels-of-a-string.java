class Solution {
//     public String reverseVowels(String s) {
//         int left = 0;
//         int right = s.length() - 1;
//         String vowels = "aeiouAEIOU";

//         while (left < right) {
//             if (!vowels.contains(String.valueOf(s.charAt(left)))) {
//                 left++;
//                 continue;
//             }
//             if (!vowels.contains(String.valueOf(s.charAt(right)))) {
//                 right--;
//                 continue;
//             }

//             s = swap(left, right, s);
//             left++;
//             right--;
//         }

//         return s;
//     }

//     private String swap(int i, int j, String s) {
//         char[] chars = s.toCharArray();
//         char temp = chars[i];
//         chars[i] = chars[j];
//         chars[j] = temp;

//         return new String(chars);
//     }
public String reverseVowels(String s) {
    int i=0,j=s.length()-1;
    char [] ch=s.toCharArray();
    while(i<j){
        while(i<j&&ch[i]!='a'&&ch[i]!='e'&&ch[i]!='i'&&ch[i]!='o'&&ch[i]!='u'&&ch[i]!='A'&&ch[i]!='E'&&ch[i]!='I'&&ch[i]!='O'&&ch[i]!='U'){
            i++;
        }
        while(j>i&&ch[j]!='a'&&ch[j]!='e'&&ch[j]!='i'&&ch[j]!='o'&&ch[j]!='u'&&ch[j]!='A'&&ch[j]!='E'&&ch[j]!='I'&&ch[j]!='O'&&ch[j]!='U'){
            j--;
        }
        if(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    return String.valueOf(ch);
}
}