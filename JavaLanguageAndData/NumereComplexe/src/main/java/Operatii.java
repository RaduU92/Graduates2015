/**
 * Created by rursu on 7/20/2015.
 */
public class Operatii {
    NumarComplex n1;
    NumarComplex n2;

    public NumarComplex adunare(NumarComplex nc1, NumarComplex nc2) {
        NumarComplex suma = new NumarComplex(0,0);
        suma.im = nc1.im + nc2.im;
        suma.re = nc1.re + nc2.im;
        return suma;
    }

    public NumarComplex inmultire (NumarComplex nc1, NumarComplex nc2) {
        NumarComplex produs = new NumarComplex(0,0);
        produs.re = nc1.re * nc2.re - nc1.im * nc2.im;
        produs.im = nc1.re * nc2.im + nc1.im * nc2.re;
        return produs;
    }
}
