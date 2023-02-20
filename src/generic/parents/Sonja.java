package generic.parents;

import java.util.Random;

public class Sonja extends Bumo {


    public Sonja(byte[] val, int off, int len) {
        super(val, off, len);
    }

    public Sonja(byte[] val) {
        super(val);
    }

    public Sonja(int signum, byte[] magnitude, int off, int len) {
        super(signum, magnitude, off, len);
    }

    public Sonja(int signum, byte[] magnitude) {
        super(signum, magnitude);
    }

    public Sonja(String val, int radix) {
        super(val, radix);
    }

    public Sonja(String val) {
        super(val);
    }

    public Sonja(int numBits, Random rnd) {
        super(numBits, rnd);
    }

    public Sonja(int bitLength, int certainty, Random rnd) {
        super(bitLength, certainty, rnd);
    }
}
