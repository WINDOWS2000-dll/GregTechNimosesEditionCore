package gtne.api.capabilities;

import java.math.BigInteger;

public class BigIntCalc {

    private BigIntCalc() {
        /**/
    }

    public static BigInteger min(BigInteger x, BigInteger y) {
        int result = x.compareTo(y);
        BigInteger minValue;

        if (result < 0) {
            minValue = x;
        } else {
            minValue = y;
        }

        return minValue;

    }

    public static BigInteger max(BigInteger x, BigInteger y) {

        int result = x.compareTo(y);
        BigInteger maxValue;

        if (result < 0) {
            maxValue = y;
        } else {
            maxValue = x;
        }

        return maxValue;

    }

    public static BigInteger summarizedValues(long[] values) {

        BigInteger RETValue = BigInteger.ZERO;
        long currentSum = 0L;
        long[] sumValues = values;
        int digits = values.length;

        for (int i = 0; i < digits; ++i) {

            long value = sumValues[i];
            if (currentSum != 0L && value > Long.MAX_VALUE - currentSum) {
                RETValue = RETValue.add(BigInteger.valueOf(currentSum));
                currentSum = 0L;
            }

            currentSum += value;

        }

        if (currentSum != 0L) {
            RETValue = RETValue.add(BigInteger.valueOf(currentSum));
        }

        return RETValue;

    }

    public static BigInteger clamp(BigInteger value, BigInteger min, BigInteger max) {
        int result = value.compareTo(min);
        return result < 0 ? min : min(value, max);
    }

}
