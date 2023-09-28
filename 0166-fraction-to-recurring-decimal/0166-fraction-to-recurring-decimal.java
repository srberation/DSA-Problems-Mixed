class Solution {
    StringBuilder sb;
    public String fractionToDecimal(int num, int den) {
        if(num == 0) return "0";

        sb = new StringBuilder();
        addSign(num,den);
        divideNumber(num,den);

        return sb.toString();
    }

    private void addSign(int a, int b){
       if((a > 0 && b > 0) || (a < 0 && b < 0)){
            return;
        }    
        sb.append("-");
    }

    private void divideNumber(int a, int b){
        long num = Math.abs((long)a);
        long den = Math.abs((long)b);

        sb.append(num/den);
        num=num%den;
        if(num == 0) return ; // means num%den = 0
        appendDecimalPart(num,den);
    }

    private void appendDecimalPart(long num, long den){

        HashMap<Long, Integer> map = new HashMap();
        sb.append(".");
        while( num != 0){
            num = num * 10;
            sb.append(num/den);
            num = num%den;

            if(map.containsKey(num)){
                sb.insert(map.get(num),"("); // sb.insert(pos,value)
                sb.append(")");
                return;
            }else{
                map.put(num, sb.length());
            }

        }

    }

}