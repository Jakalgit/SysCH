
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static String dg = "0123456789ABCDEFGHI";

    public static void main(String[] args) {
        
    }

    public static String fromDec(BigInteger ch, int sysCh){
        String strCh = "";

        while(!ch.equals(Big(0))){
            strCh = strCh + dg.charAt(Integer.parseInt(String.valueOf(ch.mod(Big(sysCh))))); //+digit[Integer.parseInt(String.valueOf((ch.mod(Big(sysCh)))))];
            ch = ch.divide(Big(sysCh));
        }

        String itog = "";

        for(int i = 0; i < strCh.length(); i++){
            itog = itog + strCh.charAt(strCh.length() - i - 1);
        }

        return itog;
    }

    public static BigInteger toDec(String ch, int sysCh){
        BigInteger itog = Big(0);
        StringBuffer strBf = new StringBuffer(ch);

        while((strBf.indexOf("0") == 0)){
            strBf.delete(0, 1);
        }

        for(int i = 0; i < strBf.length(); i++){
            itog = ((itog.multiply(Big(sysCh))));
            itog = itog.add(Big(dg.indexOf(strBf.charAt(i) + 1)));
            itog = itog.subtract(Big(1));
        }

        return itog;
    }

    public static BigInteger step(BigInteger ch, int step){
        BigInteger itog = Big(1);

        for(int i = 0; i < step; i++){
            itog = itog.multiply(ch);
        }

        return itog;
    }

    public static BigInteger Big(int n){
        return BigInteger.valueOf(n);
    }

}
