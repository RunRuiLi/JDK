/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.lang.model.util;


import javax.lang.model.element.*;

import static javax.lang.model.SourceVersion.*;
import javax.lang.model.SourceVersion;
import javax.annotation.processing.SupportedSourceVersion;

/**
 * A skeletal visitor for annotation values with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_6 RELEASE_6}
 * source version.
 *
 * <p> <b>WARNING:</b> The {@code AnnotationValueVisitor} interface
 * implemented by this class may have methods added to it in the
 * future to accommodate new, currently unknown, language structures
 * added to future versions of the Java&trade; programming language.
 * Therefore, methods whose names begin with {@code "visit"} may be
 * added to this class in the future; to avoid incompatibilities,
 * classes which extend this class should not declare any instance
 * methods with names beginning with {@code "visit"}.
 *
 * <p>When such a new visit method is added, the default
 * implementation in this class will be to call the {@link
 * #visitUnknown visitUnknown} method.  A new abstract annotation
 * value visitor class will also be introduced to correspond to the
 * new language level; this visitor will have different default
 * behavior for the visit method in question.  When the new visitor is
 * introduced, all or portions of this visitor may be deprecated.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 *
 * @see AbstractAnnotationValueVisitor7
 * @see AbstractAnnotationValueVisitor8
 * @see AbstractAnnotationValueVisitor9
 * @since 1.6
 */
@SupportedSourceVersion(RELEASE_6)
public abstract class AbstractAnnotationValueVisitor6<R, P>
    implements AnnotationValueVisitor<R, P> {

    /**
     * Constructor for concrete subclasses to call.
     * @deprecated Release 6 is obsolete; update to a visitor for a newer
     * release level.
     */
    @Deprecated
    protected AbstractAnnotationValueVisitor6() {}

    /**
     * Visits any annotation value as if by passing itself to that
     * value's {@link AnnotationValue#accept accept}.  The invocation
     * {@code v.visit(av, p)} is equivalent to {@code av.accept(v, p)}.
     * @param av {@inheritDoc}
     * @param p  {@inheritDoc}
     */
    public final R visit(AnnotationValue av, P p) {
        return av.accept(this, p);
    }

    /**
     * Visits an annotation value as if by passing itself to that
     * value's {@link AnnotationValue#accept accept} method passing
     * {@code null} for the additional parameter.  The invocation
     * {@code v.visit(av)} is equivalent to {@code av.accept(v,
     * null)}.
     * @param av {@inheritDoc}
     */
    public final R visit(AnnotationValue av) {
        return av.accept(this, null);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec The default implementation of this method in {@code
     * AbstractAnnotationValueVisitor6} will always throw {@code
     * new UnknownAnnotationValueException(av, p)}.  This behavior is not
     * required of a subclass.
     *
     * @param av {@inheritDoc}
     * @param p  {@inheritDoc}
     */
    @Override
    public R visitUnknown(AnnotationValue av, P p) {
        throw new UnknownAnnotationValueException(av, p);
    }
}