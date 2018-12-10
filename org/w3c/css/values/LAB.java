//
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM, Keio University, Beihang University 2018.
// Please first read the full copyright statement in file COPYRIGHT.html
//
package org.w3c.css.values;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;

import java.math.BigDecimal;

public class LAB {
    String output = null;
    CssValue vl, va, vb, alpha;
    boolean faSet = false;

    /**
     * Create a new HSL
     */
    public LAB() {
    }

    public static final CssValue filterL(ApplContext ac, CssValue val)
            throws InvalidParamException {
        if (val.getRawType() == CssTypes.CSS_CALC) {
            // TODO add warning about uncheckability
            // might need to extend...
        } else {
            if (val.getType() == CssTypes.CSS_NUMBER) {
                CssCheckableValue v = val.getCheckableValue();
                if (!v.isPositive()) {
                    ac.getFrame().addWarning("out-of-range", val.toString());
                    CssNumber nb = new CssNumber();
                    nb.setIntValue(0);
                    return nb;
                }
                if (val.getRawType() == CssTypes.CSS_NUMBER) {
                    BigDecimal pp = ((CssNumber) val).value;
                    if (pp.compareTo(HWB.s100) > 0) {
                        ac.getFrame().addWarning("out-of-range", val.toString());
                        CssNumber nb = new CssNumber();
                        nb.setIntValue(100);
                        return nb;
                    }
                }
            }
        }
        return val;
    }

    public final void setL(ApplContext ac, CssValue val)
            throws InvalidParamException {
        output = null;
        vl = filterL(ac, val);

    }

    public final void setA(ApplContext ac, CssValue val)
            throws InvalidParamException {
        output = null;
        va = val;
    }

    public final void setB(ApplContext ac, CssValue val)
            throws InvalidParamException {
        output = null;
        vb = val;
    }

    public final void setAlpha(ApplContext ac, CssValue val)
            throws InvalidParamException {
        output = null;
        faSet = true;
        alpha = RGBA.filterAlpha(ac, val);
    }


    /**
     * Returns a string representation of the object.
     */
    public String toString() {
        if (output == null) {
            StringBuilder sb = new StringBuilder("lab(");
            sb.append(vl).append(" ");
            sb.append(va).append(" ");
            sb.append(vb);
            if (faSet) {
                sb.append(", ").append(alpha);
            }
            sb.append(")");
            output = sb.toString();
        }
        return output;
    }
}
