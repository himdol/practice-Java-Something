package generic.parents;

import java.math.BigInteger;
import java.util.Random;

public class Bumo extends BigInteger {


    public Bumo(byte[] val, int off, int len) {
        super(val, off, len);
    }

    public Bumo(byte[] val) {
        super(val);
    }

    public Bumo(int signum, byte[] magnitude, int off, int len) {
        super(signum, magnitude, off, len);
    }

    public Bumo(int signum, byte[] magnitude) {
        super(signum, magnitude);
    }

    public Bumo(String val, int radix) {
        super(val, radix);
    }

    public Bumo(String val) {
        super(val);
    }

    public Bumo(int numBits, Random rnd) {
        super(numBits, rnd);
    }

    public Bumo(int bitLength, int certainty, Random rnd) {
        super(bitLength, certainty, rnd);
    }
}
