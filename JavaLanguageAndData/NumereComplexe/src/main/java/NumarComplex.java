/**
 * Created by rursu on 7/20/2015.
 */
public class NumarComplex {
    public float re;
    public float im;

    NumarComplex(float real, float imag) {
        this.re = real;
        this.im = imag;
    }

    public String afisareNC () {
        String s = this.re + " i*" + this.im;
        return s;
    }
}
