// $Id$
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @spec https://www.w3.org/TR/2019/WD-css-overscroll-1-20190606/#propdef-overscroll-behavior-y
 */
public class CssOverscrollBehaviorY extends org.w3c.css.properties.css.CssOverscrollBehaviorY {

    /**
     * Create a new CssOverscrollBehaviorY
     */
    public CssOverscrollBehaviorY() {
        value = initial;
    }

    /**
     * Creates a new CssOverscrollBehaviorY
     *
     * @param expression The expression for this property
     * @throws InvalidParamException
     *          Expressions are incorrect
     */
    public CssOverscrollBehaviorY(ApplContext ac, CssExpression expression, boolean check)
            throws InvalidParamException {
        setByUser();
        value = CssOverscrollBehavior.checkOverscrollBehaviorAxis(ac, expression, check, this);
    }

    public CssOverscrollBehaviorY(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }


}

